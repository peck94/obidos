package peck.obidos.views;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.ListSelect;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import peck.obidos.controllers.MainController;
import peck.obidos.domain.Listener;
import peck.obidos.models.MainModel;
import peck.obidos.models.messages.Message;

/**
 * View for the main part of the application.
 * @author jonathan
 */
public final class MainView extends VerticalLayout implements View, Listener {
    // store controller
    private final MainController controller;
    // store model
    private final MainModel model;
    // controls
    private ListSelect lstOutput;
    private Label lblNick;

    public MainView(MainController controller, MainModel model) {
        this.controller = controller;
        this.model = model;
        
        model.addListener(this);
        init();
    }
    
    public void init() {
        setSizeFull();
        
        HorizontalLayout hl = new HorizontalLayout();
        
        // chat log
        lstOutput = new ListSelect();
        lstOutput.setWidth("100%");
        lstOutput.setHeight("100%");
        lstOutput.setRows(10);
        
        // chat input
        final TextField txtInput = new TextField();
        lblNick = new Label();
        
        // chat button
        Button btnSend = new Button("Send");
        btnSend.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                String input = txtInput.getValue();
                controller.sendMessage(input);
                txtInput.setValue("");
            }
        });
        
        // menu
        Button btnConfig = new Button("Settings");
        btnConfig.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                controller.settings();
            }
        });
        
        // add components
        addComponent(btnConfig);
        addComponent(lstOutput);
        hl.addComponent(lblNick);
        hl.addComponent(txtInput);
        hl.addComponent(btnSend);
        addComponent(hl);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
    }

    @Override
    public void update(Object model) {
        MainModel mainModel = (MainModel) model;
        
        // update messages
        lstOutput.clear();
        for(Message m: mainModel.getMessages()) {
            lstOutput.addItem(m);
        }
        
        // update nickname
        if(mainModel.getUser() != null) {
            lblNick.setValue(mainModel.getUser().getNick());
        }
    }
    
}
