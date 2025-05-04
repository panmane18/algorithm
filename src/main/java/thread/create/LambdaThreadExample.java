package thread.create;

public class LambdaThreadExample {
    public static void main(String[] args) {
        // Create a thread using lambda
        Thread thread = new Thread(() -> {
            System.out.println("Thread is running using lambda!");
        });

        // Start the thread
        thread.start();
    }
}