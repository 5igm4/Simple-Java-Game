package src.pokeServer;
import java.io.IOException;
import java.util.logging.*;

import javax.websocket.*;

import src.wsMessages.*;

import javax.websocket.server.ServerEndpoint;

/**
 * What does this server do when it receives a message from a client?
 * 
 * @author sdexter72
 *
 */
 
@ServerEndpoint(value = "/game",decoders = { MessageDecoder.class }, encoders = { 
		GameControllerEncoder.class, StartGameEncoder.class, SetPlayerControllerEncoder.class
		, EndGameEncoder.class })
public class GameServerEndpoint {
	public static Session current;
 
    private Logger logger = Logger.getLogger(this.getClass().getName());
    
    /**
     * 
     * On connection this sends a set player controller message to 
     * tell the game to set the client as player one
     */
    @OnOpen
    public void onOpen(Session peer) {
    	int size = peer.getOpenSessions().size();
		System.out.println("SESSION SIZE: " + size );
		if(size <= 2) {
			logger.info("Connected ... " + peer.getId());
			if(size == 1){
		        for (Session other : peer.getOpenSessions()) {
		            try {
		                other.getBasicRemote().sendObject(new SetPlayerControllerMessage(true));
		            } catch (IOException | EncodeException ex) {
		                Logger.getLogger(GameServerEndpoint.class.getName()).log(Level.SEVERE, null, ex);
		            }
		        }
			}
			if(size == 2){ //when we reach two players, send a StartGameMessage
		        for (Session other : peer.getOpenSessions()) {
		            try {
		                other.getBasicRemote().sendObject(new StartGameMessage(true));
		            } catch (IOException | EncodeException ex) {
		                Logger.getLogger(GameServerEndpoint.class.getName()).log(Level.SEVERE, null, ex);
		            }
		        }
			}
//    		else  
//    			peer.close();
		}
    }
    /**
     * This function is what notifies the other other player 
     * of the current direction of the ball
     * @param peer session
     * @param msg message
     * @throws EncodeException if something goes wrong with encoding
     */
    @OnMessage
    public void onMessage(Session peer, Message msg) throws EncodeException {
        logger.log(Level.FINE, "Message {0} from {1}", new Object[]{msg, peer.getId()});
        for (Session other : peer.getOpenSessions()) {
            try {
                other.getBasicRemote().sendObject(msg);
            } catch (IOException ex) {
                Logger.getLogger(GameServerEndpoint.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
 
    @OnClose
    public void onClose(Session session, CloseReason closeReason) {
        logger.info(String.format("Session %s closed because of %s", session.getId(), closeReason));
    }
    
 
}
