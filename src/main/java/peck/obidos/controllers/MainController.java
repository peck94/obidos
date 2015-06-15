package peck.obidos.controllers;

import com.vaadin.navigator.Navigator;
import peck.obidos.models.MainModel;
import peck.obidos.models.messages.ChatMessage;

/**
 * Controller for the main view.
 * @author jonathan
 */
public class MainController extends Controller {
    // store the model
    private final MainModel model;
    
    /**
     * Init the controller.
     * @param model Model to use
     */
    public MainController(MainModel model, Navigator navigator) {
        super(navigator);
        this.model = model;
    }
    
    /**
     * Send a chat message to the current channel.
     * @param input The message to send.
     */
    public void sendMessage(String input) {
        // create message
        ChatMessage msg = new ChatMessage(input);
        
        // send to all
        model.getManager().sendMessage(msg);
        // add to model
        model.addMessage(msg);
    }
    
    public void settings() {
        getNavigator().navigateTo("config");
    }
    
    public void connect() {
        getNavigator().navigateTo("connect");
    }
}
