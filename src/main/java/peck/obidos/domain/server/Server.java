package peck.obidos.domain.server;

import com.vaadin.ui.Notification;
import java.net.ServerSocket;
import java.net.Socket;
import peck.obidos.domain.ConnectionManager;
import peck.obidos.domain.Listener;
import peck.obidos.models.MainModel;

/**
 * The server lets other people initiate chat sessions with us.
 * @author jonathan
 */
public class Server extends Thread implements Listener {
    // store model
    private final MainModel model;
    // store state
    private boolean running;
    private int port;
    
    public Server(MainModel model) {
        this.model = model;
        this.running = true;
        this.port = model.getPort();
        
        model.addListener(this);
    }

    @Override
    public void run() {
        // as long as the server is running
        while(running) {
            // setup the socket
            ServerSocket socket;
            try {
                socket = new ServerSocket(port);
            } catch (Exception e) {
                System.out.println(e);
                Notification.show("Server error.\n" + e.getLocalizedMessage(),
                        Notification.Type.ERROR_MESSAGE);
                return;
            }
            try{
                // listen for an incoming connection
                Socket client = socket.accept();
                model.getManager().addConnection(client, model);
            }catch(Exception e) {
                System.out.println(e);
            }
        }
    }
    
    /**
     * Stop the server.
     */
    public void shutdown() {
        running = false;
    }

    @Override
    public void update(Object model) {
        MainModel mainModel = (MainModel) model;
        
        // check for a change in port number
        if(mainModel.getPort() != port) {
            this.port = mainModel.getPort();
        }
    }
}
