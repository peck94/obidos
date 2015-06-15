package peck.obidos.controllers;

import peck.obidos.models.MainModel;
import peck.obidos.models.Person;

/**
 * Controller for the config view.
 * @author jonathan
 */
public class ConfigController {
    // store the model
    private final MainModel model;
    
    public ConfigController(MainModel model) {
        this.model = model;
    }
    
    /**
     * Save the config.
     * @param nick Nickname to use
     */
    public void save(String nick) {
        Person user = new Person(nick);
        model.setUser(user);
    }
}
