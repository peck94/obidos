package peck.obidos.controllers;

import com.vaadin.navigator.Navigator;

/**
 * Controller for connection.
 * @author jonathan
 */
public class ConnectController extends Controller {
    public ConnectController(Navigator navigator) {
        super(navigator);
    }
    
    public void connect(String host, int port) {
        getNavigator().navigateTo("main");
    }
    
    public void cancel() {
        getNavigator().navigateTo("main");
    }
}
