package peck.obidos.controllers;

import com.vaadin.navigator.Navigator;
import com.vaadin.ui.Notification;
import peck.obidos.domain.client.Client;
import peck.obidos.models.MainModel;

/**
 * Controller for connection.
 * @author jonathan
 */
public class ConnectController extends Controller {
    private MainModel model;
    
    public ConnectController(MainModel model, Navigator navigator) {
        super(navigator);
        this.model = model;
    }
    
    public void connect(String host, int port) {
        try{
            Client client = new Client(model, host, port);
            client.start();
            getNavigator().navigateTo("main");
        }catch(Exception e) {
            Notification.show("Failed to connect.\n" + e.getLocalizedMessage(),
                    Notification.Type.ERROR_MESSAGE);
        }
    }
    
    public void cancel() {
        getNavigator().navigateTo("main");
    }
}
