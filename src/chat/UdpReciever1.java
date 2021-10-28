package chat;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpReciever1 {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(7777);

        while (true) {
            byte[] bt = new byte[1024];
            DatagramPacket packet = new DatagramPacket(bt, bt.length);
            socket.receive(packet);

            byte[] data = packet.getData();
            String datas = new String(data, 0, packet.getLength());

            System.out.println(datas);
            if (datas.equals("bye")) {
                break;
            }
        }

        socket.close();
    }

}
