package peck.obidos.domain;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;
import peck.obidos.models.messages.Message;

/**
 * This class is responsible for sending and receiving serialized messages
 * over a socket.
 * @author jonathan
 */
public class Communicator implements Observer {
    // store socket
    private Socket socket;
    // store streams
    private ObjectOutputStream output;
    private ObjectInputStream input;
    // store listeners
    private List<Listener> listeners;

    /**
     * Setup a connection through a socket.
     * @param socket Socket to use
     * @throws IOException 
     */
    public Communicator(Socket socket) throws IOException {
        this.socket = socket;
        this.output = new ObjectOutputStream(socket.getOutputStream());
        this.input = new ObjectInputStream(socket.getInputStream());
        listeners = new LinkedList<>();
    }
    
    /**
     * Send a message.
     * @param msg Message to send.
     * @throws IOException 
     */
    public void sendMessage(Message msg) throws IOException {
        output.writeObject(msg);
        output.flush();
    }
    
    public Message recvMessage() throws IOException {
        Message msg;
        try{
            msg = (Message) input.readObject();
        }catch(ClassNotFoundException e) {
            msg = null;
        }
        
        return msg;
    }
    
    /**
     * Close the connection.
     * @throws java.io.IOException
     */
    public void close() throws IOException {
        output.close();
        socket.close();
    }

    @Override
    public void addListener(Listener l) {
        listeners.add(l);
    }

    @Override
    public void removeListener(Listener l) {
        listeners.remove(l);
    }

    public void invalidate(Message msg) {
        for(Listener l: listeners) {
            l.update(msg);
        }
    }
}
