package chat;

public class ChatStudent {
    public static void main(String[] args) {
        new Thread(new ChatReciever("学生", 9999)).start();
        new Thread(new ChatSender(7777, "localhost", 8888)).start();
    }
}
