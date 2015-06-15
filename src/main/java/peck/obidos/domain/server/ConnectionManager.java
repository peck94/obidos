package peck.obidos.domain.server;

import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import peck.obidos.domain.Communicator;
import peck.obidos.models.MainModel;
import peck.obidos.models.Person;

/**
 * Manages connections with rmeote clients.
 * @author jonathan
 */
public class ConnectionManager {
    /**
     * Initiate a new connection.
     * @param client Client to connect with.
     */
    public void addConnection(Socket client) throws IOException {
        // create communicator
        Communicator comm = new Communicator(client);
        
        // create monitor
        Monitor monitor = new Monitor(comm);
        monitor.start();
    }
}
