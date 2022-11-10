import java.io.FileWriter;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        MyThread thread = new MyThread('a');
        MyThread thread2 = new MyThread('b');
        thread.start();
        thread2.start();



        /*
    try {

        FileWriter f = new FileWriter("fileThreads.txt");
    }catch (Exception e) {
        System.out.println("ERROR");
    }
    */

    }
}