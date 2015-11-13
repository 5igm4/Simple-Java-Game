
import java.io.IOException;
import java.util.logging.*;

import javax.websocket.*;

import wsMessages.*;

import javax.websocket.server.ServerEndpoint;

/*
 * This is the game server endpoint. You'll need to hook it up with whatever encoders/decoders you want, as well as the code that tracks the "game logic."
 */

@ServerEndpoint()
public class GameServerEndpoint {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @OnOpen
    public void onOpen(Session peer) {
        logger.info("Connected ... " + peer.getId());
    }

    @OnMessage
    public void onMessage(Session peer, Message msg) throws EncodeException {
    }

    @OnClose
    public void onClose(Session session, CloseReason closeReason) {
    }


}
