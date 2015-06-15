package peck.obidos.domain;

/**
 * Observer interface.
 * @author jonathan
 */
public interface Observer {
    /**
     * Add a listener to the observer.
     * @param l Listener to add.
     */
    void addListener(Listener l);
    
    /**
     * Remove a listener from the observer.
     * @param l Listener to remove.
     */
    void removeListener(Listener l);
    
    /**
     * Invalidate the observer.
     * This should notify all listeners.
     */
    void invalidate();
}
