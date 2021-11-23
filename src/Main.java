import java.util.Scanner;


class Mass implements Runnable{

    public void run() {
        while (Main.p<Main.q) {
            Main.q = Main.q+1;
            Main.array[Main.q] = Main.array[Main.p]+Main.array[Main.p+1];
            Main.p = Main.p+2;
//            System.out.printf("%s: %s \n", Thread.currentThread().getName(), Main.array[Main.q]);
        }
    }
}

public class Main {
    public static long[] array;
    public static int p;
    public static int q;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input a size of array: ");
        int size = in.nextInt();
        System.out.print("Input a number of threads: ");
        int numThreads = in.nextInt();
        array = new long[2*size];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
                    //(int) Math.round((Math.random()*200 - 100));
        }
        long checkRes = (array[0] + array[size-1]) * size / 2;

        p = 0;
        q = size-1;
        for (int i = 0; i < numThreads; i++) {
            new Thread(new Mass()).start();
        }

//        for (long el : array) {
//            System.out.println(el);
//        }

        System.out.println("Result: " + array[q]);
        System.out.println("Check: " + checkRes);
    }
}
