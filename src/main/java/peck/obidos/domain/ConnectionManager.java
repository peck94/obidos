package peck.obidos.domain;

import java.io.IOException;
import java.net.Socket;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import peck.obidos.models.MainModel;
import peck.obidos.models.messages.Message;
import peck.obidos.models.messages.NickReplyMessage;

/**
 * Manages connections with rmeote clients.
 * @author jonathan
 */
public class ConnectionManager {
    // store list of connections
    private List<Communicator> connections;
    // store model
    private MainModel model;
    
    /**
     * Continuously checks for dead connections.
     */
    private class Pinger extends Thread {
        @Override
        public void run() {
            while(true) {
                Iterator<Communicator> itr = connections.iterator();
                while(itr.hasNext()) {
                    Communicator c = itr.next();
                    if(!c.isConnected()) {
                        model.removePerson(c.getSocket());
                        itr.remove();
                    }
                }
                try{
                    Thread.sleep(1000);
                }catch(Exception e) {
                    System.out.println(e);
                    break;
                }
            }
        }
    }
    
    public ConnectionManager(MainModel model) {
        connections = new LinkedList<>();
        this.model = model;
        
        Pinger p = new Pinger();
        p.start();
    }
    
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
        
        // add to list
        connections.add(comm);
    }
    
    /**
     * Send a message to all connected folks.
     * @param msg Message to send.
     */
    public void sendMessage(Message msg) {
        for(Communicator c: connections) {
            try{
                c.sendMessage(msg);
            }catch(Exception e) {
                System.out.println(e);
            }
        }
    }
}
