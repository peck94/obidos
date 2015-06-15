package peck.obidos.models;

import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import peck.obidos.domain.Listener;
import peck.obidos.domain.Observer;
import peck.obidos.models.messages.Message;

/**
 * Model for the main view.
 * @author jonathan
 */
public class MainModel implements Observer {
    // store listeners
    private List<Listener> listeners;
    // store list of chat messages
    private List<Message> messages;
    // store map of persons
    private Map<Socket, Person> people;
    // store own persona
    private Person user;
    // store server config
    private int port;
    
    public MainModel() {
        // init listeners
        listeners = new LinkedList<>();
        // init message list
        messages = new ArrayList<>();
        // init people
        people = new HashMap<>();
    }
    
    @Override
    public void addListener(Listener l) {
        listeners.add(l);
    }
    
    @Override
    public void removeListener(Listener l) {
        listeners.remove(l);
    }

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
    
    /**
     * Add a person to the model.
     * @param s Socket of person.
     * @param p Person to add.
     */
    public void addPerson(Socket s, Person p) {
        people.put(s, p);
        invalidate();
    }
    
    /**
     * Remove person from the model.
     * @param s Socket of person to remove.
     */
    public void removePerson(Socket s) {
        people.remove(s);
        invalidate();
    }
    
    /**
     * @return List of people.
     */
    public Map<Socket, Person> getPeople() {
        return new HashMap<>(people);
    }
    
    public Person getUser() {
        return user;
    }
    
    public void setUser(Person user) {
        this.user = user;
        invalidate();
    }
    
    public int getPort() {
        return port;
    }
    
    public void setPort(int port) {
        this.port = port;
        invalidate();
    }
}
