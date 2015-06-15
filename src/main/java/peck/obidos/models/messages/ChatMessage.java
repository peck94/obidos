package peck.obidos.models.messages;

/**
 * Represents an ordinary chat message.
 * @author jonathan
 */
public class ChatMessage extends Message {

    public ChatMessage(String message) {
        super(message, Message.Type.CHAT);
    }
    
}
