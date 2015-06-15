package peck.obidos.controllers;

import com.vaadin.navigator.Navigator;
import com.vaadin.ui.Notification;
import peck.obidos.models.MainModel;
import peck.obidos.models.Person;

/**
 * Controller for the config view.
 * @author jonathan
 */
public class ConfigController extends Controller {
    // store the model
    private final MainModel model;
    
    public ConfigController(MainModel model, Navigator navigator) {
        super(navigator);
        this.model = model;
    }
    
    /**
     * Save the config.
     * @param nick Nickname to use
     */
    public void save(String nick, int port) {
        // update model
        Person user = new Person(nick);
        model.setUser(user);
        model.setPort(port);
        
        // go back
        getNavigator().navigateTo("main");
    }
}
