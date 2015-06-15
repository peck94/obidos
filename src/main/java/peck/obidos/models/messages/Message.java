package peck.obidos.models.messages;

import java.io.Serializable;

/**
 * Represents a chat message.
 * @author jonathan
 */
public class Message implements Serializable {
    // store message
    private final String message;
    // store type
    private final Type type;
    
    public enum Type {
        // chat message
        CHAT,
        // request nickname
        REQUEST_NICK,
        // answer nickname
        REPLY_NICK
    }
    
    /**
     * Create a new message.
     * @param message Message contents
     * @param type Type of message
     */
    public Message(String message, Type type) {
        this.message = message;
        this.type = type;
    }
    
    public String getMessage() {
        return message;
    }
    
    public Type getType() {
        return type;
    }
    
    @Override
    public String toString() {
        return message;
    }
}
