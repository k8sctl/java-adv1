package thread.start.test;

import static util.MyLogger.*;

public class StartTest2Main {

    public static void main(String[] args) {
        Runnable runnable = new ConterRunnable();
        Thread thread = new Thread(runnable, "counter");
        // thread.setName("counter");
        thread.start();
    }

    static class ConterRunnable implements Runnable {

        @Override
        public void run() {
            for (int i = 1 ; i <= 5 ; i++) {
                log("value: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
