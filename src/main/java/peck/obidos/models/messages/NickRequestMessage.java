package peck.obidos.models.messages;

/**
 * Message requesting nickname.
 * @author jonathan
 */
public class NickRequestMessage extends Message {

    public NickRequestMessage() {
        super("", Message.Type.REQUEST_NICK);
    }
    
}
