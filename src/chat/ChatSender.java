package chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class ChatSender implements Runnable {
    DatagramSocket socket = null;
    BufferedReader bufferedReader = null;

    private int fromPort;
    private String toIP;
    private int toPort;

    public ChatSender(int fromPort, String toIP, int toPort) {
        this.fromPort = fromPort;
        this.toIP = toIP;
        this.toPort = toPort;

        try {
            socket = new DatagramSocket(this.fromPort);
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        while (true) {
            try {
                String data = bufferedReader.readLine();
                byte[] bt = data.getBytes();
                DatagramPacket packet = new DatagramPacket(bt, bt.length,
                        new InetSocketAddress(this.toIP, this.toPort));

                socket.send(packet);

                if (data.equals("bye")) {
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        socket.close();

    }
}
