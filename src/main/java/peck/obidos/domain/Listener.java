package peck.obidos.domain;

/**
 * Interface for listeners.
 * @author jonathan
 */
public interface Listener {
    /**
     * Send an update notification to the listener.
     * @param model Model that has been updated.
     */
    void update(Object model);
}
