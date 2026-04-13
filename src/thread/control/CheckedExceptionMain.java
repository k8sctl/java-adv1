package thread.control;

import util.ThreadUtils;

public class CheckedExceptionMain {

    public static void main(String[] args) throws Exception {
        throw new Exception();
    }

    static class CheckRunnable implements Runnable {

        // [체크 예외]
        // 부모 메서드가 체크 예외를 던지지 않는 경우, 재정의된 자식 메서드도 체크 예외를 던질 수 없다.
        // 자식 메서드는 부모 메서드가 던질 수 있는 체크 에외의 하위 타입만 던질 수 있다.
        // [언체크(런타임) 예외]
        // 예외 처리를 강제하지 않으므로 상관없이 던질 수 있다.
        @Override
        public void run() /*throws Exception*/{
            // throw new Exception(); // 주석 풀면 예외 발생
        }
    }
}
