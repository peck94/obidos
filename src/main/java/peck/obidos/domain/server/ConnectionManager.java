package peck.obidos.domain.server;

import java.io.IOException;
import java.net.Socket;
import peck.obidos.domain.Communicator;
import peck.obidos.domain.Monitor;
import peck.obidos.models.MainModel;
import peck.obidos.models.messages.NickReplyMessage;

/**
 * Manages connections with rmeote clients.
 * @author jonathan
 */
public class ConnectionManager {
    /**
     * Initiate a new connection.
     * @param client Client to connect with.
     * @param model Program model
     * @throws java.io.IOException
     */
    public void addConnection(Socket client, MainModel model) throws IOException {
        // create communicator
        Communicator comm = new Communicator(client);
        
        // create monitor
        Monitor monitor = new Monitor(comm);
        monitor.start();
        
        // send nick reply
        comm.sendMessage(new NickReplyMessage(model));
    }
}
