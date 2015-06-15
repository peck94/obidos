package peck.obidos.views;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import peck.obidos.controllers.ConnectController;

/**
 * View for the connection dialog.
 * @author jonathan
 */
public class ConnectView extends VerticalLayout implements View {
    private final ConnectController controller;
    
    public ConnectView(ConnectController controller) {
        this.controller = controller;
        init();
    }
    
    public void init() {
        HorizontalLayout hl = new HorizontalLayout();
        HorizontalLayout hl2 = new HorizontalLayout();
        HorizontalLayout hl3 = new HorizontalLayout();
        
        final TextField txtHost = new TextField();
        
        hl.addComponent(new Label("Host:"));
        hl.addComponent(txtHost);
        
        final TextField txtPort = new TextField();
        
        hl2.addComponent(new Label("Port:"));
        hl2.addComponent(txtPort);
        
        Button btnConnect = new Button("Connect");
        btnConnect.addStyleName(ValoTheme.BUTTON_PRIMARY);
        btnConnect.addClickListener(new ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                String host = txtHost.getValue();
                int port;
                try{
                    port = Integer.parseInt(txtPort.getValue());
                    controller.connect(host, port);
                }catch(NumberFormatException e) {
                    Notification.show("Invalid port number.",
                            Notification.Type.ERROR_MESSAGE);
                }
            }
        });
        
        Label lblTitle = new Label("Connect");
        lblTitle.addStyleName(ValoTheme.LABEL_H1);
        
        Button btnCancel = new Button("Cancel");
        btnCancel.addClickListener(new ClickListener() {

            @Override
            public void buttonClick(Button.ClickEvent event) {
                controller.cancel();
            }
        });
        
        addComponent(lblTitle);
        addComponent(hl);
        addComponent(hl2);
        hl3.addComponent(btnConnect);
        hl3.addComponent(btnCancel);
        addComponent(hl3);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
    }
    
}
