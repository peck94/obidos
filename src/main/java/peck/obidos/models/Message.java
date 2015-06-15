package peck.obidos.models;

/**
 * Represents a chat message.
 * @author jonathan
 */
public class Message {
    // store message
    private final String message;
    
    /**
     * Create a new message.
     * @param message Message contents
     */
    public Message(String message) {
        this.message = message;
    }
    
    @Override
    public String toString() {
        return message;
    }
}
