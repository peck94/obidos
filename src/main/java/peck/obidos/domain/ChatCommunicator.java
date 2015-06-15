package peck.obidos.domain;

import java.io.IOException;
import peck.obidos.models.messages.Message;
import peck.obidos.models.messages.NickRequestMessage;

/**
 * This class decorates the Communicator with auxiliary methods.
 * @author jonathan
 */
public class ChatCommunicator {
    // store communicator
    private final Communicator communicator;
    
    public ChatCommunicator(Communicator communicator) {
        this.communicator = communicator;
    }
    
    /**
     * Request the nickname.
     * @return 
     * @throws java.io.IOException 
     */
    public String getNick() throws IOException {
        Message out = new NickRequestMessage();
        communicator.sendMessage(out);
        
        Message in = communicator.recvMessage();
        return in.getMessage();
    }
}
