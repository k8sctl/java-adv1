package thread.control.yield;

import static util.ThreadUtils.sleep;

public class YieldMain {

    static final int THREAD_COUNT = 1000;

    public static void main(String[] args) {
        for (int i = 0 ; i < THREAD_COUNT ; i++) {
            Thread thread = new Thread(new MyRunnable());
            thread.start();
        }
    }

    static class MyRunnable implements Runnable {

        @Override
        public void run() {
            for (int i = 0 ; i < 10 ; i++) {
                System.out.println(Thread.currentThread().getName() + " - " + i);
                // 1. empty
                // sleep(1); // 2. sleep
                // Thread.yield(); // 3. yield - yield는 쓰레드의 상태가 바뀌지 않고 스케줄링 대기 큐로 들어간다.
            }
        }
    }
}
