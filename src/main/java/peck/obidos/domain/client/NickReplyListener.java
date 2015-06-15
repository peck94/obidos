package peck.obidos.domain.client;

import peck.obidos.models.MainModel;
import peck.obidos.models.Person;
import peck.obidos.models.messages.Message.Type;
import peck.obidos.models.messages.SocketMessage;

/**
 * Listens for nickname replies.
 * @author jonathan
 */
public class NickReplyListener extends MessageListener {
    private final MainModel model;

    public NickReplyListener(MainModel model) {
        super(Type.REPLY_NICK);
        this.model = model;
    }

    @Override
    public void handle(SocketMessage msg) {
        String nick = msg.getMessage();
        model.removePerson(msg.getSocket());
        model.addPerson(msg.getSocket(), new Person(nick));
    }
    
}
