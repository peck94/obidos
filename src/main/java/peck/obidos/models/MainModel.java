package peck.obidos.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
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
    // store set of persons
    private Set<Person> people;
    // store own persona
    private Person user;
    
    public MainModel() {
        // init listeners
        listeners = new LinkedList<>();
        // init message list
        messages = new ArrayList<>();
        // init people
        people = new HashSet<>();
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
    
    /**
     * Add a person to the model.
     * @param p Person to add.
     */
    public void addPerson(Person p) {
        people.add(p);
    }
    
    /**
     * Remove person from the model.
     * @param p Person to remove.
     */
    public void removePerson(Person p) {
        people.remove(p);
    }
    
    /**
     * @return List of people.
     */
    public Set<Person> getPeople() {
        return new HashSet<>(people);
    }
    
    public Person getUser() {
        return user;
    }
    
    public void setUser(Person user) {
        this.user = user;
        invalidate();
    }
}
