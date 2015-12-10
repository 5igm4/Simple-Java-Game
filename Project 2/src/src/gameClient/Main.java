package src.gameClient;
import java.awt.BorderLayout;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.websocket.ClientEndpoint;
import javax.websocket.CloseReason;
import javax.websocket.DeploymentException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;

import org.glassfish.tyrus.client.ClientManager;

import src.wsMessages.*;

/**
 * Sets up the GUI and starts the game.
 * 
 * @author sdexter72
 *
 */
@ClientEndpoint(decoders = { MessageDecoder.class }, encoders = {
		GameControllerEncoder.class, StartGameEncoder.class, SetPlayerControllerEncoder.class })
public class Main{
	private Logger logger = Logger.getLogger(this.getClass().getName());
	private static CountDownLatch latch;
	
	@OnOpen
	public void onOpen(Session session) {
		logger.info("Connected ... " + session.getId());
		try {
			session.getBasicRemote().sendText("start");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@OnMessage
	public void onMessage(Session session, Message message) {
		logger.info("Received ...." + message.toString());
		
		//TODO Change this to differentiate between player 1 and player 2
		if (message instanceof GameControllerMessage) {
			GameController.receivePoke((GameControllerMessage) message);
		}
		else if (message instanceof StartGameMessage) {
			GamePanel.setStart(true);
		}
		else if (message instanceof SetPlayerControllerMessage) {
			System.out.println("GOT PLAYER 1");
			GamePanel.setPlayer1(true);
		}
		else {
			logger.info("Message not instance of GameControllerMessage...");
		}
	}

	@OnClose
	public void onClose(Session session, CloseReason closeReason) {
		logger.info(String.format("Session %s close because of %s",
				session.getId(), closeReason));
		latch.countDown();
	}

    public static void main(String[] args) {
    	
		latch = new CountDownLatch(1);

		final Session peer;
		ClientManager client = ClientManager.createClient();
		try {
			peer = client.connectToServer(Main.class, new URI(
					"ws://localhost:8025/websockets/game"));
    			
	        javax.swing.SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	            	displayScreen(peer);
	            }
	        });
			latch.await();
		
		} catch (DeploymentException | URISyntaxException
				| InterruptedException | IOException e) {
			throw new RuntimeException(e);
		}

    }

	
private static void displayScreen(Session peer) {

    JFrame frame = new JFrame("Let's Play...");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(new BorderLayout());
    
    // bare bones: just add a panel where the game objects are drawn
    
    GamePanel gamePanel = new GamePanel();
    frame.add(gamePanel);

    frame.setSize(500, 500);
    frame.setResizable(false);
    frame.setVisible(true);
    
    // the game starts when the gamepanel animation begins

    gamePanel.go(peer);
    
    

}

}