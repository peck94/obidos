package peck.obidos.domain;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import peck.obidos.models.messages.Message;
import peck.obidos.models.messages.SocketMessage;

/**
 * This class is responsible for sending and receiving serialized messages
 * over a socket.
 * @author jonathan
 */
public class Communicator {
    // store socket
    private final Socket socket;
    // store streams
    private final ObjectOutputStream output;
    private final ObjectInputStream input;

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
    
    public Socket getSocket() {
        return socket;
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
    
    public SocketMessage recvMessage() throws IOException {
        SocketMessage msg;
        try{
            Message msg1 = (Message) input.readObject();
            msg = new SocketMessage(msg1.getMessage(), msg1.getType(), socket);
        }catch(ClassNotFoundException e) {
            msg = null;
        }
        
        return msg;
    }
    
    public boolean isConnected() {
        return socket.isConnected();
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
