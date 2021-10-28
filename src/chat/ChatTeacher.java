package chat;

public class ChatTeacher {
    public static void main(String[] args) {
        new Thread(new ChatReciever("老师", 8888)).start();
        new Thread(new ChatSender(6666, "localhost", 9999)).start();
    }
}
