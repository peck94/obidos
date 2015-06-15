package peck.obidos.controllers;

import peck.obidos.models.MainModel;
import peck.obidos.models.Message;

/**
 * Controller for the main view.
 * @author jonathan
 */
public class MainController {
    // store the model
    private final MainModel model;
    
    /**
     * Init the controller.
     * @param model Model to use
     */
    public MainController(MainModel model) {
        this.model = model;
    }
    
    /**
     * Send a chat message to the current channel.
     * @param input The message to send.
     */
    public void sendMessage(String input) {
        // add the message to the model
        model.addMessage(new Message(input));
    }
}
