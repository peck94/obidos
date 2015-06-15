package peck.obidos.domain;

import peck.obidos.domain.client.MessageHandler;
import peck.obidos.models.messages.SocketMessage;

/**
 * Monitors a connection for messages.
 * @author jonathan
 */
public class Monitor extends Thread {
    private Communicator communicator;
    
    public Monitor(Communicator communicator) {
        this.communicator = communicator;
    }
    
    @Override
    public void run() {
        while(communicator.isConnected()) {
            try{
                SocketMessage msg = communicator.recvMessage();
                MessageHandler.get().dispatch(msg);
            }catch(Exception e) {
                System.out.println(e);
            }
        }
    }
}
