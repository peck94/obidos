package peck.obidos.views;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import peck.obidos.controllers.ConfigController;
import peck.obidos.models.MainModel;
import peck.obidos.models.Person;

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
    private TextField txtNick;
    
    public ConfigView(ConfigController controller, MainModel model) {
        this.controller = controller;
        this.model = model;
        init();
    }
    
    public void init() {
        HorizontalLayout hl = new HorizontalLayout();
        hl.addComponent(new Label("Nick:"));
        
        txtNick = new TextField();
        hl.addComponent(txtNick);
        
        Button btnSave = new Button("Save");
        btnSave.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                String nick = txtNick.getValue();
                controller.save(nick);
            }
            
        });
        
        addComponent(hl);
        addComponent(btnSave);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        if(model.getUser() != null) {
            txtNick.setValue(model.getUser().getNick());
        }
    }
    
}
