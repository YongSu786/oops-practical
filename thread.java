class ChatUser extends Thread {
    private String userName;
    private volatile boolean suspended = false;
    private volatile boolean stopped = false;

    public ChatUser(String name) {
        this.userName = name;
    }

    public void run() {
        int count = 1;
        while (!stopped && count <= 5) {
            synchronized (this) {
                while (suspended) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        System.out.println(userName + " interrupted!");
                    }
                }
            }

            System.out.println(userName + " says: Message " + count);
            count++;

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(userName + " interrupted!");
            }
        }

        System.out.println(userName + " has left the chat.");
    }

    public void suspendThread() {
        suspended = true;
    }

    public synchronized void resumeThread() {
        suspended = false;
        notify();
    }

    public void stopThread() {
        stopped = true;
    }
}

public class ThreadDemo {
    public static void main(String[] args) {

        ChatUser user1 = new ChatUser("Alice");
        ChatUser user2 = new ChatUser("Bob");
        ChatUser user3 = new ChatUser("Admin");

        user1.setPriority(Thread.NORM_PRIORITY);
        user2.setPriority(Thread.NORM_PRIORITY);
        user3.setPriority(Thread.MAX_PRIORITY);

        user1.start();
        user2.start();
        user3.start();

        System.out.println("Is Alice alive? " + user1.isAlive());
        System.out.println("Is Bob alive? " + user2.isAlive());
        System.out.println("Is Admin alive? " + user3.isAlive());

        try {
            Thread.sleep(1500);

            System.out.println(">>> Suspending Bob...");
            user2.suspendThread();
            Thread.sleep(1500);

            System.out.println(">>> Resuming Bob...");
            user2.resumeThread();
            Thread.sleep(1500);

            System.out.println(">>> Stopping Alice...");
            user1.stopThread();

            user1.join();
            user2.join();
            user3.join();

        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted!");
        }

        System.out.println("Is Alice alive? " + user1.isAlive());
        System.out.println("Is Bob alive? " + user2.isAlive());
        System.out.println("Is Admin alive? " + user3.isAlive());
        System.out.println("Chat session ended.");
    }
}
