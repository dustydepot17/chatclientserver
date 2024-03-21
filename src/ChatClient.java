import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

public class ChatClient extends JFrame{
    public ChatClient(String nome) {
        super("Chat Client");

        this.getSize(new Dimension(500, 300));
        this.setLocationRelativeTo(null);
        this.setEnabled(true);
        this.setBackground(Color.blue);

        PannelloChatClient pan = new PannelloChatClient(nome);

        this.getContentPane().add(pan);
        this.setVisible(true);
    }
}
