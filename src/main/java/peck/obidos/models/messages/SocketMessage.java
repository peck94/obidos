package peck.obidos.models.messages;

import java.net.Socket;

/**
 * Decorator to add originating socket to message.
 * @author jonathan
 */
public class SocketMessage extends Message {
    private final Socket socket;
    
    public SocketMessage(String message, Type type, Socket socket) {
        super(message, type);
        this.socket = socket;
    }
    
    public Socket getSocket() {
        return socket;
    }
}
