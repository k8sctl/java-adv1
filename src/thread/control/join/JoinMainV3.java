package thread.control.join;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

// 스택 프레임 내부에 자신을 호출한 인스턴스의 참조값이 this로 가지고 있다.
// 그래서 특정 메서드 안에서 this를 호출하면 바로 스택 프레임 안에 있는 this 값을 불러서 사용하게 된다.
public class JoinMainV3 {

    public static void main(String[] args) throws  InterruptedException {
        log("Start");
        SumTask task1 = new SumTask(1, 50);
        SumTask task2 = new SumTask(51, 100);
        Thread thread1 = new Thread(task1, "thread-1");
        Thread thread2 = new Thread(task2, "thread-2");

        thread1.start();
        thread2.start();

        // 스레드가 종료될 때 까지 대기 - WAITING(무기한 대기)
        log("join() - main 스레드가 thread1, thread2가 종료까지 대기");
        thread1.join();
        thread2.join();
        log("main 스레드 대기 종료");

        log("task1.result = " + task1.result);
        log("task2.result = " + task2.result);

        int sumAll = task1.result + task2.result;
        log("task1 + task2 = " + sumAll);
        log("End");
    }

    static class SumTask implements Runnable {

        int startValue;
        int endValue;
        int result = 0;

        public SumTask(int startValue, int endValue) {
            this.startValue = startValue;
            this.endValue = endValue;
        }

        @Override
        public void run() {
            log("작업 시작");
            sleep(2000);
            int sum = 0;
            for (int i = startValue; i <= endValue; i++) {
                sum += i;
            }
            result = sum;
            log("작업 완료 = " + result);
        }
    }
}
