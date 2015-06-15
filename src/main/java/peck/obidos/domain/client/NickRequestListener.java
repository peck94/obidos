package peck.obidos.domain.client;

import peck.obidos.domain.Communicator;
import peck.obidos.models.MainModel;
import peck.obidos.models.messages.Message;
import peck.obidos.models.messages.NickReplyMessage;
import peck.obidos.models.messages.SocketMessage;

/**
 * Listens to requests for nickname.
 * @author jonathan
 */
public class NickRequestListener extends MessageListener {
    private final MainModel model;
    
    public NickRequestListener(MainModel model) {
        super(Message.Type.REQUEST_NICK);
        this.model = model;
    }

    @Override
    public void handle(SocketMessage msg) {
        try{
            Communicator c = new Communicator(msg.getSocket());
            c.sendMessage(new NickReplyMessage(model));
        }catch(Exception e) {
            System.out.println(e);
        }
    }
    
}
