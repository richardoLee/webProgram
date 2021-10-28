package chat;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ChatReciever implements Runnable {
    DatagramSocket socket = null;

    private String user;
    private int port;

    public ChatReciever(String user, int port) {
        this.user = user;
        this.port = port;

        try {
            socket = new DatagramSocket(this.port);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                byte[] bt = new byte[1024];
                DatagramPacket packet = new DatagramPacket(bt, bt.length);
                socket.receive(packet);

                byte[] data = packet.getData();
                String datas = new String(data, 0, packet.getLength());

                System.out.println(user + ": " + datas);
                if (datas.equals("bye")) {
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
