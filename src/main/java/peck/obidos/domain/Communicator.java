package peck.obidos.domain;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import peck.obidos.models.messages.Message;

/**
 * This class is responsible for sending and receiving serialized messages
 * over a socket.
 * @author jonathan
 */
public class Communicator {
    // store socket
    private Socket socket;
    // store streams
    private ObjectOutputStream output;
    private ObjectInputStream input;
    
    /**
     * Setup a connection through a socket.
     * @param socket Socket to use
     * @throws IOException 
     */
    public Communicator(Socket socket) throws IOException {
        this.socket = socket;
        this.output = new ObjectOutputStream(socket.getOutputStream());
        this.input = new ObjectInputStream(socket.getInputStream());
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
}
