package peck.obidos;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;
import peck.obidos.controllers.ConfigController;
import peck.obidos.controllers.MainController;
import peck.obidos.models.MainModel;
import peck.obidos.views.ConfigView;
import peck.obidos.views.MainView;

/**
 * Main application class.
 */
@Title("Obidos")
@Theme("valo")
@Widgetset("peck.obidos.ObidosWidgetSet")
public class ObidosUI extends UI {
    private Navigator navigator;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        // init model
        MainModel model = new MainModel();
        
        // setup view navigation
        navigator = new Navigator(this, this);
        navigator.addView("main",
                new MainView(new MainController(model, navigator), model));
        navigator.addView("config",
                new ConfigView(new ConfigController(model, navigator), model));
        
        // navigate to initial view
        navigator.navigateTo("config");
    }

    @WebServlet(urlPatterns = "/*", name = "ObidosUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = ObidosUI.class, productionMode = false)
    public static class ObidosUIServlet extends VaadinServlet {
    }
}
