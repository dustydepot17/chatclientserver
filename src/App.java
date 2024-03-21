public class App {
    public static void main(String[] args) throws Exception {
        ChatServer server = new ChatServer();
        ChatClient client1 = new ChatClient("Francesco");
        ChatClient client2 = new ChatClient("Mario");
        ChatClient client3 = new ChatClient("Giulia");
        ChatClient client4 = new ChatClient("Sara");
    }
}
