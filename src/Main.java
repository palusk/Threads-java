import java.awt.event.KeyAdapter;
import java.io.*;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main extends KeyAdapter {
    public static void main(String[] args) throws IOException {

        System.out.println("How many threads do you want to start?");
        Scanner sc = new Scanner(System.in);
        int threadsNumber = sc.nextInt();



        ExecutorService executorService = Executors.newFixedThreadPool(threadsNumber);
        for(int i=0; i<threadsNumber; i++){
            executorService.submit(()-> FileReader.readFile(Thread.currentThread().getName()));
        }



        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line = "";

        while (line.equalsIgnoreCase("quit") == false) {
            line = in.readLine();
            executorService.shutdownNow();
            System.out.println("koniec");
        }

}
}