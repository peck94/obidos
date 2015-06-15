package peck.obidos.controllers;

import com.vaadin.navigator.Navigator;

/**
 * Base class for all controllers.
 * @author jonathan
 */
public abstract class Controller {
    // store the navigator
    private Navigator navigator;
    
    public Controller(Navigator navigator) {
        this.navigator = navigator;
    }
    
    public Navigator getNavigator() {
        return navigator;
    }
}
