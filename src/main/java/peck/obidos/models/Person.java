package peck.obidos.models;

/**
 * Represents a person in the chat.
 * @author jonathan
 */
public class Person {
    // store nickname
    private final String nick;
    
    /**
     * Create a person.
     * @param nick Nickname to be displayed
     */
    public Person(String nick) {
        this.nick = nick;
    }
    
    public String getNick() {
        return nick;
    }
}
