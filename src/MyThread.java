import java.io.*;

public class MyThread extends Thread{
    char threadID;
    int privateLineCount = 0;
    static int globalLineCount = 0;

    char tab[] = new char[2];

    public MyThread(char threadID) {
        this.threadID = threadID;
    }

    public void readFile() {
        try {
            //@@@@@@@@@@@@@@@@ odczyt danych o biletach
            String strLine = new String();
            FileInputStream f = new FileInputStream(".\\fileThreads.txt");
            DataInputStream in = new DataInputStream(f);
            BufferedReader r = new BufferedReader(new InputStreamReader(in));
            while (strLine != null) {
                if(privateLineCount < globalLineCount){
                    strLine = r.readLine();
                    privateLineCount++;
                }else if (tab[1] == threadID && tab[0] == threadID) {

                } else{ System.out.println(threadID + strLine);
                    tab[1] = tab[0];
                    tab[0] = threadID;
                    strLine = r.readLine();
                    privateLineCount++;
                    globalLineCount++;
                }
            }
            in.close();
        } catch (Exception e) {
            System.out.println("Error nie otwarto pliku");
        }
    }

    public void run(){
    readFile();
    }
}
