import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PannelloChatClient extends JPanel{
    private String nome;
    private List lista;
    private TextField textNuovo;
    ThreadChatClient client;

    public PannelloChatClient(String nome) {
        super();
        this.nome = nome;
        this.setBackground(new Color(60, 200, 60));
        JPanel panLista = new JPanel(new BorderLayout(20, 5));
        panLista.setBackground(new Color(60, 200, 60));
        lista = new List();
        lista.setBackground(Color.lightGray);
        lista.setSize(100, 50);
        lista.setVisible(true);

        JLabel chat1 = new JLabel("  Chat  ", JLabel.CENTER);
        chat1.setForeground(new Color(200, 100, 100));
        JLabel chat2 = new JLabel("  Chat  ", JLabel.CENTER);
        chat2.setForeground(new Color(200, 100, 100));

        panLista.add(chat1, BorderLayout.WEST);
        panLista.add(lista, BorderLayout.CENTER);
        panLista.add(chat2, BorderLayout.EAST);

        JPanel nuovoMex = new JPanel(new BorderLayout(20, 5));
        nuovoMex.setBackground(new Color(60, 200, 60));

        JLabel labNuovo = new JLabel("Nuovo Messaggio -> ", JLabel.CENTER);
        labNuovo.setForeground(new Color(255, 255, 0));

        textNuovo = new TextField("");

        JButton buttonInvia = new JButton("Invia");
        buttonInvia.addActionListener(new ActionListener() { 
            
            public void actionPerformed(ActionEvent e){
                String bottone = e.getActionCommand();
                if(bottone.equals("Invia"))
                {
                    client.spedisciMessaggioChat(nome + ": " + textNuovo.getText());
                    textNuovo.setText("");
                }
            }
            
        });

        nuovoMex.add(labNuovo, BorderLayout.WEST);
        nuovoMex.add(textNuovo, BorderLayout.CENTER);
        nuovoMex.add(buttonInvia, BorderLayout.EAST);

        this.setLayout(new BorderLayout(0, 5));
        add(panLista, BorderLayout.CENTER);
        add(nuovoMex, BorderLayout.SOUTH);
        connetti();
    }

    public void connetti() {
        client = new ThreadChatClient(lista, "127.0.0.1", 5243);
    }

    public void actionPerformetd(ActionEvent e){
        String bottone = e.getActionCommand();
        if(bottone.equals("Invia"))
        {
            client.spedisciMessaggioChat(textNuovo.getText());
            textNuovo.setText("");
        }
    }
    
}
