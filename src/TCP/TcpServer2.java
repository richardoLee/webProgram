package TCP;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer2 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        System.out.println("system".toString());
        try {
            serverSocket = new ServerSocket(9999);

            socket = serverSocket.accept();
            is = socket.getInputStream();

            FileOutputStream fos = new FileOutputStream(new File("output.docx"));

            byte[] buffer = new byte[1024];
            int len;

            while ((len = is.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }

            OutputStream os = socket.getOutputStream();
            os.write("服务器结束，你可以断开了".getBytes());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (baos != null)
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (is != null)
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (socket != null)
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (serverSocket != null)
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
}
