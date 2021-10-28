package chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class UdpSender1 {
    public static void main(String[] args) throws Exception {

        DatagramSocket socket = new DatagramSocket(9999);

        // buffer
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String data = bufferedReader.readLine();
            byte[] bt = data.getBytes();
            DatagramPacket packet = new DatagramPacket(bt, bt.length, new InetSocketAddress("localhost", 7777));

            socket.send(packet);

            if (data.equals("bye")) {
                break;
            }
        }

        socket.close();

    }
}
