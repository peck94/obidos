package peck.obidos.models.messages;

import peck.obidos.models.MainModel;

/**
 * Replies with our nickname.
 * @author jonathan
 */
public class NickReplyMessage extends Message {
    public NickReplyMessage(MainModel model) {
        super(model.getUser().getNick(), Type.REPLY_NICK);
    }
}
