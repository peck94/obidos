package peck.obidos.domain.client;

import peck.obidos.models.MainModel;
import peck.obidos.models.Person;
import peck.obidos.models.messages.Message;
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
        String nick = msg.getMessage();
        model.removePerson(msg.getSocket());
        model.addPerson(msg.getSocket(), new Person(nick));
    }
    
}
