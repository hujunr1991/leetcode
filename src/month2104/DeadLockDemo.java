package month2104;

public class DeadLockDemo {

    private static Object resource1 = new Object();//资源 1
    private static Object resource2 = new Object();//资源 2

    public static void main(String[] args) {

        new Thread( () -> {
            synchronized (resource1) {

                sleep(2000);
                System.out.println("等待资源resource2");

                synchronized (resource2) {
                    System.out.println("线程1完成");
                }
            }
        }).start();

        new Thread( () -> {
            synchronized (resource2) {

                sleep(2000);
                System.out.println("等待资源resource2");

                synchronized (resource1) {
                    System.out.println("线程1完成");
                }
            }
        }).start();


    }

    private static void sleep(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
