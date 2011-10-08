/*
 * OrderSystemServerApp.java
 */

package ordersystemclient;

import ordersystemclient.model.HostModel;
import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;

/**
 * The main class of the applicaion.
 */
public class OrderSystemClientApp extends SingleFrameApplication {

    /**
     * At startup create and show the main frame of the application.
     */
    @Override protected void startup() {
        // import model
        HostModel clientModel = new HostModel();
        show(new OrderSystemClientView(this,clientModel));
    }

    /**
     * This method is to initialize the specified window by injecting resources.
     * Windows shown in our application come fully initialized from the GUI
     * builder, so this additional configuration is not needed.
     */
    @Override protected void configureWindow(java.awt.Window root) {
    }

    /**
     * A convenient static getter for the application instance.
     * @return the instance of OrderSystemServerApp
     */
    public static OrderSystemClientApp getApplication() {
        return Application.getInstance(OrderSystemClientApp.class);
    }

    /**
     * Main method launching the application.
     */
    public static void main(String[] args) {
        launch(OrderSystemClientApp.class, args);
    }
}
