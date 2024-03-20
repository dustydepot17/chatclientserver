
import java.io.*;
import java.net.*;

public class ThreadChatConnessioni implements Runnable {
    private ThreadGestioneServizioChat gestoreChat;
    private Socket client = null;
    private BufferedReader input = null;
    private PrintWriter output = null;
    Thread me;

    public ThreadChatConnessioni(ThreadGestioneServizioChat gestoreChat, Socket client) {
        this.gestoreChat = gestoreChat;
        this.client = client;

        try {
            this.input = new BufferedReader(new InputStreamReader(client.getInputStream()));
            this.output = new PrintWriter(this.client.getOutputStream(), true);
        } catch (Exception e) {
            output.println("Erroe di lettura");
        }
        me = new Thread(this);
        me.start();
    }
    public void run() {
        while (true) {
            try {
                String mex = null;

                while ((mex = input.readLine()) == null) {}
                gestoreChat.spedisciMessaggio(mex);
            } catch (Exception e) {
                output.println();
            }
        }
    }
}
