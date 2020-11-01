import java.text.SimpleDateFormat;
import java.util.Date;

class SyncThread implements Runnable {
    /*
       同步：同一时间只有一个线程对需同步的代码块进行访问
       异步：同一时间可能有很多个线程对代码块进行访问
       考点：同步保证执行顺序和代码顺序一致，异步不保证
    */

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        if (threadName.startsWith("A")) {
            // A 类线程访问方法中没有synchronized，因此 A 类线程是异步的，所以有线程访问对象的同步代码块时，另外的线程可以访问该对象的非同步代码块
            async();
        } else if (threadName.startsWith("B")) {
            // B 类线程访问的方法中有synchronized，因此 B 类线程是同步的，一个线程在访问对象的同步代码块，另一个访问对象的同步代码块的线程会被阻塞
            sync1();
        } else if (threadName.startsWith("C")) {
            // C 类线程访问的是 synchronized 修饰非静态方法，C 类线程是同步的，一个线程在访问对象的同步代方法，另一个访问对象同步方法的线程会被阻塞
            sync2();
        }
    }

    /**
     * 异步方法
     */
    private void async() {
        try {
            System.out.println(Thread.currentThread().getName() + "_Async_Start: " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + "_Async_End: " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 方法中有 synchronized(this|object) {} 同步代码块
     */
    private void sync1() {
        // synchronized(this|object) {} 代码块之外的代码依然是异步的：
        System.out.println(Thread.currentThread().getName() + "_Sync1: " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
        synchronized (this) {
            try {
                System.out.println(Thread.currentThread().getName() + "_Sync1_Start: " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + "_Sync1_End: " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * synchronized 修饰非静态方法
     * synchronized 的作用范围是整个方法，所以方法中所有的代码都是同步的
     */
    private synchronized void sync2() {
        System.out.println(Thread.currentThread().getName() + "_Sync2: " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
        try {
            System.out.println(Thread.currentThread().getName() + "_Sync2_Start: " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + "_Sync2_End: " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // 在 Java 5 中提供了...(变长参数)，允许在调用方法时传入不定长度的参数。变长参数是 Java 的一个语法糖，本质上还是基于数组的实现
    // main("arg1", "arg2", "arg3")
    public static void main(String... args) {
        SyncThread syncThread = new SyncThread();
        Thread A_thread1 = new Thread(syncThread, "A_thread1");
        Thread A_thread2 = new Thread(syncThread, "A_thread2");
        Thread B_thread1 = new Thread(syncThread, "B_thread1");
        Thread B_thread2 = new Thread(syncThread, "B_thread2");
        Thread C_thread1 = new Thread(syncThread, "C_thread1");
        Thread C_thread2 = new Thread(syncThread, "C_thread2");
        A_thread1.start();
        A_thread2.start();
        B_thread1.start();
        B_thread2.start();
        C_thread1.start();
        C_thread2.start();
    }

    /* []表示同步结果，{}表示异步结果 */
    /* 第一次结果：
        {B_thread2_Sync1: 02:14:43
        A_thread1_Async_Start: 02:14:43
        A_thread2_Async_Start: 02:14:43
        B_thread1_Sync1: 02:14:43}
        [C_thread1_Sync2: 02:14:43
        C_thread1_Sync2_Start: 02:14:43
        {A_thread1_Async_End: 02:14:45
        A_thread2_Async_End: 02:14:45}
        C_thread1_Sync2_End: 02:14:45]
        [B_thread1_Sync1_Start: 02:14:45
        B_thread1_Sync1_End: 02:14:47]
        [B_thread2_Sync1_Start: 02:14:47
        B_thread2_Sync1_End: 02:14:49]
        [C_thread2_Sync2: 02:14:49
        C_thread2_Sync2_Start: 02:14:49
        C_thread2_Sync2_End: 02:14:51]
     */

    /* 第二次结果：
        {B_thread2_Sync1: 02:20:37
        B_thread1_Sync1: 02:20:37
        A_thread2_Async_Start: 02:20:37}
        [C_thread1_Sync2: 02:20:37
        {A_thread1_Async_Start: 02:20:37}
        C_thread1_Sync2_Start: 02:20:37
        {A_thread2_Async_End: 02:20:39
        A_thread1_Async_End: 02:20:39}
        C_thread1_Sync2_End: 02:20:39]
        [B_thread1_Sync1_Start: 02:20:39
        B_thread1_Sync1_End: 02:20:41]
        [B_thread2_Sync1_Start: 02:20:41
        B_thread2_Sync1_End: 02:20:43]
        [C_thread2_Sync2: 02:20:43
        C_thread2_Sync2_Start: 02:20:43
        C_thread2_Sync2_End: 02:20:45]
     */
}