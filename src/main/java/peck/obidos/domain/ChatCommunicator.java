package peck.obidos.domain;

import java.io.IOException;
import java.net.Socket;
import peck.obidos.models.messages.Message;
import peck.obidos.models.messages.NickRequestMessage;

/**
 * This class decorates the Communicator with auxiliary methods.
 * @author jonathan
 */
public class ChatCommunicator extends Communicator {
    public ChatCommunicator(Socket client) throws IOException {
        super(client);
    }
    
    /**
     * Request the nickname.
     * @return 
     * @throws java.io.IOException 
     */
    public String getNick() throws IOException {
        Message out = new NickRequestMessage();
        sendMessage(out);
        
        Message in = recvMessage();
        return in.getMessage();
    }
}
