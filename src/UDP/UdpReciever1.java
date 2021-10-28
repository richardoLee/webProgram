package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpReciever1 {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(9090);

        byte[] msg = new byte[1024];

        DatagramPacket packet = new DatagramPacket(msg, msg.length);

        socket.receive(packet);

        System.out.println(packet.getAddress());
        System.out.println(new String(packet.getData()));

        socket.close();
    }
}
