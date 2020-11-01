
public class Worker implements Runnable {
    int workitem = 0;

    static final int WORK_ITEMS = 1000;
    static final int WORKERS = 4;

    private void pretendToDoWork() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /* 考点: 确保在锁被释放之前，对共享变量所做的修改，对于随后获得该锁的另一个线程是可见的 */
    synchronized
    private int incWorkItem() {
        return workitem++;
    }

    @Override
    public void run() {
        int mytasks = 0;

        int myworkitem;
        while ((myworkitem = incWorkItem()) < WORK_ITEMS) {
            pretendToDoWork();
            mytasks++;
        }
        System.out.println("Thread "+Thread.currentThread().getName()+ " did "+mytasks+" tasks.");
    }

    public static void main(String[] args) {
        Worker worker = new Worker();
        Thread[] threads = new Thread[WORKERS];

        for (int i = 0; i < WORKERS; i++) {
            threads[i] = new Thread(worker,"Worker "+i);
        }

        for (int i = 0; i < WORKERS; i++) {
            // 启动线程
            threads[i].start();
        }

        try {
            for (int i = 0; i < WORKERS; i++) {
                // Thread.join方法是将指定线程加入当前线程，将两个交替执行的线程转换成顺序执行。
                // 语句threads[i].join()，在线程main中，调用线程threads[i]的join方法，将线程threads[i]加入线程main中，先执行完线程threads[i]，再执行main线程。
                threads[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All done!");
    }
}

