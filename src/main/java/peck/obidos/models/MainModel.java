package peck.obidos.models;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import peck.obidos.domain.Listener;
import peck.obidos.domain.Observer;

/**
 * Model for the main view.
 * @author jonathan
 */
public class MainModel implements Observer {
    // store listeners
    private List<Listener> listeners;
    // store list of chat messages
    private List<Message> messages;
    
    public MainModel() {
        // init listeners
        listeners = new LinkedList<>();
        // init message list
        messages = new ArrayList<>();
    }
    
    @Override
    public void addListener(Listener l) {
        listeners.add(l);
    }
    
    @Override
    public void removeListener(Listener l) {
        listeners.remove(l);
    }

    @Override
    public void invalidate() {
        for(Listener l: listeners) {
            l.update(this);
        }
    }
    
    /**
     * Add a message to the model.
     * @param msg Message to add
     */
    public void addMessage(Message msg) {
        messages.add(msg);
        invalidate();
    }
    
    /**
     * @return List of messages
     */
    public List<Message> getMessages() {
        return new ArrayList<>(messages);
    }
}
