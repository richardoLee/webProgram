package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpSender1 {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();

        String msg = "hello reciever";
        InetAddress inetAddress = InetAddress.getLocalHost();
        int port = 9090;

        DatagramPacket packet = new DatagramPacket(msg.getBytes(), msg.getBytes().length, inetAddress, port);

        socket.send(packet);

        socket.close();
    }
}
