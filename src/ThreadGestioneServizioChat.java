
import java.net.ServerSocket;
import java.net.Socket;
import java.awt.List;
import javax.swing.JOptionPane;

public class ThreadGestioneServizioChat implements Runnable {
    private int nMaxConnessioni;
    private List lista;
    private ThreadChatConnessioni[] listaConnessioni;
    Thread me;
    private ServerSocket serverChat;

    public ThreadGestioneServizioChat (int nMaxConnessioni, List lista){
        this.nMaxConnessioni = nMaxConnessioni - 1;
        this.lista = lista;
        this.listaConnessioni = new ThreadChatConnessioni[this.nMaxConnessioni];
        me = new Thread(this);
        me.start();
    }

    public void run() {
        boolean continua = true;

        try {
            serverChat = new ServerSocket(5243);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "impossibile instanziare il server");
            continua = false;
        }

        if(continua) {
            try {
                for(int xx = 0; xx < nMaxConnessioni; xx++) {
                    Socket tempo = null;
                    tempo = serverChat.accept();
                    listaConnessioni[xx] = new ThreadChatConnessioni(this, tempo);
                }
                serverChat.close();
            } catch(Exception e) {
                JOptionPane.showMessageDialog(null, "Impossibile instanziare server chat");            
            }
        }
    }

    public void spedisciMessaggio(String mex) {
        lista.add(mex);
        lista.select(lista.getItemCount() - 1);

        for(int xx = 0; xx < this.nMaxConnessioni; xx++) {
            if(listaConnessioni[xx] != null) 
            {
                listaConnessioni[xx].spedisciMessaggioChat(mex);
            }
        }
    }
}
