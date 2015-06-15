package peck.obidos.domain.client;

import java.io.IOException;
import java.net.Socket;
import peck.obidos.domain.Communicator;
import peck.obidos.domain.Monitor;
import peck.obidos.models.MainModel;
import peck.obidos.models.messages.NickReplyMessage;
import peck.obidos.models.messages.NickRequestMessage;

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
     * @param model Model to be used.
     * @param host Host to connect to.
     * @param port Port to connect on.
     * @throws IOException 
     */
    public Client(MainModel model, String host, int port) throws IOException {
        this.socket = new Socket(host, port);
        this.model = model;
    }
    
    public void start() throws IOException {
        // create communicator
        Communicator comm = new Communicator(socket);
        
        // create monitor
        Monitor monitor = new Monitor(comm);
        monitor.start();
        
        // send request for nick
        comm.sendMessage(new NickRequestMessage());
        // send own nick
        comm.sendMessage(new NickReplyMessage(model));
    }
}
