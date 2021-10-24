package TCP;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class TcpClient2 {
    public static void main(String[] args) throws Exception {
        Socket socket = null;
        OutputStream os = null;

        try {
            InetAddress serverIP = InetAddress.getByName("127.0.0.1");
            int port = 9999;
            socket = new Socket(serverIP, port);

            os = socket.getOutputStream();
            FileInputStream fis = new FileInputStream(new File("lib/theFile.docx"));

            byte[] buffer = new byte[1024];
            int len;

            while ((len = fis.read(buffer)) != -1) {
                os.write(buffer, 0, len);
            }

            socket.shutdownOutput();

            InputStream inputStream = socket.getInputStream();

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer2 = new byte[1024];
            int len2;

            while ((len2 = inputStream.read(buffer2)) != -1) {
                baos.write(buffer2, 0, len2);
            }

            System.out.println(baos.toString());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
