package thread.leetcode;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

//https://leetcode.com/problems/print-zero-even-odd/description/?envType=problem-list-v2&envId=concurrency
class ZeroEvenOdd {
    private int n;
    private Semaphore zero = new Semaphore(1);
    private Semaphore even = new Semaphore(0);
    private Semaphore odd = new Semaphore(0);
    boolean flag = true;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            zero.acquire();
            printNumber.accept(0);
            if (flag) {
                odd.release();
            } else {
                even.release();
            }
            flag = !flag;
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i = i + 2) {
            even.acquire();
            printNumber.accept(i);
            zero.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i = i + 2) {
            odd.acquire();
            printNumber.accept(i);
            zero.release();
        }
    }
}