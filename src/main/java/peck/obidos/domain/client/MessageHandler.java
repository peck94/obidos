package peck.obidos.domain.client;

import java.util.LinkedList;
import java.util.List;
import peck.obidos.domain.Listener;
import peck.obidos.domain.Observer;

/**
 * Dispatches incoming messages to the appropriate listeners.
 * @author jonathan
 */
public class MessageHandler implements Observer {
    private static MessageHandler instance;
    private List<Listener> listeners;
    
    private MessageHandler() {
        listeners = new LinkedList<>();
    }

    public static MessageHandler get() {
        if(instance == null) {
            instance = new MessageHandler();
        }
        
        return instance;
    }
    
    @Override
    public void addListener(Listener l) {
        listeners.add(l);
    }

    @Override
    public void removeListener(Listener l) {
        listeners.remove(l);
    }
}
