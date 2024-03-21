import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

public class ChatServer extends JFrame{
    public ChatServer() {
        super("Chat Server");

        this.getSize(new Dimension(500, 300));
        this.setLocationRelativeTo(null);
        this.setEnabled(true);
        this.setBackground(Color.blue);

        PannelloChatServer pan = new PannelloChatServer();

        this.getContentPane().add(pan);
        this.setVisible(true);
    }
}
