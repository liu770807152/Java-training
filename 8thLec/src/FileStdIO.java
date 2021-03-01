import java.io.IOException;

public class FileStdIO {

    public static void main(String[] args) {
        try {
            byte b = (byte) System.in.read();
           // System.out.println(b);
           // System.out.write(b);
           // System.out.flush();
            System.err.write(b);
            System.err.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
