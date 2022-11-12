import java.io.*;

public class FileReader {
    static String strLine = new String();
    static FileInputStream f;
    static String tab[] = new String[2];
    static {
        try {
            f = new FileInputStream(".\\fileThreads.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    static DataInputStream in = new DataInputStream(f);
    static BufferedReader r = new BufferedReader(new InputStreamReader(in));

    static public void readFile(String name) {
        while (strLine != null) {
            if (!(tab[1] == name && tab[0] == name)) {
                try {
                    strLine = r.readLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                if(strLine!=null)
                System.out.println(name+" "+strLine);
                tab[1] = tab[0];
                tab[0] = name;
            }
            try {
                Thread.sleep(0);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Koniec pracy wątku "+name);

    }
}
