//https://leetcode.com/problems/fizz-buzz-multithreaded/?envType=problem-list-v2&envId=concurrency
package thread.leetcode;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

class FizzBuzz {
    private int n;
    Semaphore num = new Semaphore(1);
    Semaphore fizz = new Semaphore(0);
    Semaphore buzz = new Semaphore(0);
    Semaphore fizzbuzz = new Semaphore(0);

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 != 0) {
                fizz.acquire();
                printFizz.run();
                num.release();
            }
        }

    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 5 == 0 && i % 3 != 0) {
                buzz.acquire();
                printBuzz.run();
                num.release();
            }
        }

    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 5 == 0 && i % 3 == 0) {
                fizzbuzz.acquire();
                printFizzBuzz.run();
                num.release();
            }
        }

    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            num.acquire();
            if (i % 3 == 0 && i % 5 == 0) {
                fizzbuzz.release();
            } else if (i % 3 == 0) {
                fizz.release();
            } else if (i % 5 == 0) {
                buzz.release();
            } else {
                printNumber.accept(i);
                num.release();
            }
        }

    }
}