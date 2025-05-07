package thread.leetcode;
//https://leetcode.com/problems/building-h2o/description/?envType=problem-list-v2&envId=concurrency
import java.util.concurrent.Semaphore;

class H2O {
    Semaphore hydrogen = new Semaphore(2);
    Semaphore oxygen = new Semaphore(0);

    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hydrogen.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        oxygen.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        oxygen.acquire(2);
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        hydrogen.release(2);
    }
}