package peck.obidos.views;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import peck.obidos.controllers.ConfigController;
import peck.obidos.models.MainModel;

/**
 * Set config parameters.
 * @author jonathan
 */
public final class ConfigView extends VerticalLayout implements View {
    // store model
    private final MainModel model;
    // controller
    private final ConfigController controller;
    // controls
    private TextField txtNick, txtPort;
    
    public ConfigView(ConfigController controller, MainModel model) {
        this.controller = controller;
        this.model = model;
        init();
    }
    
    public void init() {
        setSizeFull();
        HorizontalLayout hl = new HorizontalLayout();
        HorizontalLayout hl2 = new HorizontalLayout();
        
        Label lblTitle = new Label("Settings");
        lblTitle.addStyleName(ValoTheme.LABEL_H1);
        
        Label lblNick = new Label("Nick:");
        lblNick.addStyleName(ValoTheme.LABEL_LIGHT);
        hl.addComponent(lblNick);
        
        Label lblPort = new Label("Local port:");
        lblPort.addStyleName(ValoTheme.LABEL_LIGHT);
        hl2.addComponent(lblPort);
        
        txtNick = new TextField();
        txtNick.addStyleName(ValoTheme.TEXTFIELD_SMALL);
        txtNick.addStyleName(ValoTheme.TEXTFIELD_INLINE_ICON);
        txtNick.setIcon(FontAwesome.USER);
        hl.addComponent(txtNick);
        
        txtPort = new TextField();
        txtNick.addStyleName(ValoTheme.TEXTFIELD_SMALL);
        hl2.addComponent(txtPort);
        
        Button btnSave = new Button("Save");
        btnSave.addStyleName(ValoTheme.BUTTON_PRIMARY);
        btnSave.setIcon(FontAwesome.SAVE);
        btnSave.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                String nick = txtNick.getValue();
                int port;
                try{
                    port = Integer.parseInt(txtPort.getValue());
                    controller.save(nick, port);
                }catch(NumberFormatException e) {
                    Notification.show("Invalid port number.");
                }
            }
            
        });
        
        addComponent(lblTitle);
        addComponent(hl);
        addComponent(hl2);
        addComponent(btnSave);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        if(model.getUser() != null) {
            txtNick.setValue(model.getUser().getNick());
        }
        txtPort.setValue("" + model.getPort());
    }
    
}
