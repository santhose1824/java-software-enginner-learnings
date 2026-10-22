import java.util.concurrent.CyclicBarrier;

// Why StringBuffer is "thread safe" and StringBuilder is not.
// Two threads each append COUNT characters to the SAME object, so the expected length is 2 * COUNT.
// A CyclicBarrier makes both threads start at exactly the same moment so they really overlap.
// NOTE: a race condition is not guaranteed on every run - run it a few times to see StringBuilder lose updates
//       (or even throw an exception while resizing its internal array).
public class ThreadSafetyDemo {

    static final int COUNT = 1_000_000;

    public static void main(String[] args) throws Exception {

        StringBuffer buffer = new StringBuffer();      // synchronized methods
        StringBuilder builder = new StringBuilder();   // NOT synchronized

        // ---- StringBuffer: two threads ----
        CyclicBarrier barrier1 = new CyclicBarrier(2);
        Runnable bufferTask = () -> {
            try {
                barrier1.await();
                for (int i = 0; i < COUNT; i++) buffer.append('x');
            } catch (Exception e) {
                System.out.println("StringBuffer thread error: " + e);
            }
        };
        Thread t1 = new Thread(bufferTask), t2 = new Thread(bufferTask);
        t1.start(); t2.start(); t1.join(); t2.join();

        // ---- StringBuilder: two threads ----
        CyclicBarrier barrier2 = new CyclicBarrier(2);
        Runnable builderTask = () -> {
            try {
                barrier2.await();
                for (int i = 0; i < COUNT; i++) builder.append('x');
            } catch (Exception e) {
                System.out.println("StringBuilder thread error: " + e);
            }
        };
        Thread t3 = new Thread(builderTask), t4 = new Thread(builderTask);
        t3.start(); t4.start(); t3.join(); t4.join();

        System.out.println("Expected length   : " + (2 * COUNT));
        System.out.println("StringBuffer  len : " + buffer.length() + "   <- always correct (one thread at a time)");
        System.out.println("StringBuilder len : " + builder.length() + "   <- usually LESS: lost updates (race condition)");
    }
}
