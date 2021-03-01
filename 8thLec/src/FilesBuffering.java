import java.io.*;

public class FilesBuffering {
    public static void main(String[] args) {
        for (int j = 1; j < 10; j++) {
            InputStream in = null;
            OutputStream out = null;
            long start = 0;
            try {
                if (false) {
                    in = new FileInputStream("8thLec/src/hamlet.txt");
                    out = new FileOutputStream("output.txt");
                } else {
                    in = new BufferedInputStream(new FileInputStream("8thLec/src/hamlet.txt"), j * 1024);
                    out = new BufferedOutputStream(new FileOutputStream("output.txt"), j * 1024);
                }
                start = System.nanoTime();
                int i;
                while ((i = in.read()) != -1) {
                    out.write(i);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (in != null) {
                        in.close();
                    }
                    if (out != null) {
                        out.close();
                    }
                    System.out.println("That took "+((System.nanoTime()-start)/1000000)+"ms");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
