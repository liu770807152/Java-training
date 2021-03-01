import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FilesInputStream {
    public static void main(String[] args) {
        FileInputStream in = null;

        try {
            in = new FileInputStream("8thLec/src/hamlet.txt");
            for (int i = 0; i < 1000; i++) {
                byte b = 0;
                try {
                    b = (byte) in.read();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.write(b);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
