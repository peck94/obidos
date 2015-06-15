package peck.obidos.domain.client;

import peck.obidos.models.MainModel;
import peck.obidos.models.messages.Message;
import peck.obidos.models.messages.SocketMessage;

/**
 * Listen for chat messages from someone.
 * @author jonathan
 */
public class ChatMessageListener extends MessageListener {
    // store model
    private final MainModel model;

    public ChatMessageListener(MainModel model) {
        super(Message.Type.CHAT);
        
        this.model = model;
    }

    @Override
    public void handle(SocketMessage msg) {
        model.addMessage(msg);
    }
    
}
