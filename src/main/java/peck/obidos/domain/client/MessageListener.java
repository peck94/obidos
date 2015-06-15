package peck.obidos.domain.client;

import peck.obidos.domain.Listener;
import peck.obidos.models.messages.Message;
import peck.obidos.models.messages.Message.Type;

/**
 * General listener for messages.
 * @author jonathan
 */
public abstract class MessageListener extends Thread implements Listener {
    // type of message to listen for
    private final Type type;
    
    public MessageListener(Type type) {
        this.type = type;
        MessageHandler.get().addListener(this);
    }

    @Override
    public void update(Object model) {
        Message msg = (Message) model;
        if(msg.getType() == type) {
            handle(msg);
        }
    }
    
    public abstract void handle(Message msg);
    
}
