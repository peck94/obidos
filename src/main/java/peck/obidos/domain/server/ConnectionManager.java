package peck.obidos.domain.server;

import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import peck.obidos.domain.ChatCommunicator;
import peck.obidos.domain.Communicator;
import peck.obidos.models.MainModel;
import peck.obidos.models.Person;

/**
 * Manages connections with rmeote clients.
 * @author jonathan
 */
public class ConnectionManager {
    // store model
    private final MainModel model;
    // store connections
    private Map<Person, ChatCommunicator> connections;
    
    public ConnectionManager(MainModel model) {
        this.model = model;
        
        connections = new HashMap<>();
    }
    
    /**
     * Initiate a new connection.
     * @param client Client to connect with.
     */
    public void addConnection(Socket client) throws IOException {
        // create communicator
        ChatCommunicator comm = new ChatCommunicator(new Communicator(client));
        
        // create person
        Person person = new Person(comm.getNick());
        
        // add to map
        connections.put(person, comm);
    }
}
