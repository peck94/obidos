package peck.obidos.domain.client;

import java.io.IOException;
import java.net.Socket;
import peck.obidos.models.MainModel;

/**
 * Connects to a remote host to initiate a chat session.
 * @author jonathan
 */
public class Client {
    // store socket
    private final Socket socket;
    // store model
    private final MainModel model;
    
    /**
     * Init client.
     * @param model Model to use.
     * @param host Host to connect to.
     * @param port Port to connect on.
     * @throws IOException 
     */
    public Client(MainModel model, String host,
            int port) throws IOException {
        this.socket = new Socket(host, port);
        this.model = model;
    }
    
    public void start() throws IOException {
        model.getManager().addConnection(socket, model);
    }
}
