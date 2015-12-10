package src.gameClient;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.websocket.EncodeException;
import javax.websocket.Session;

import src.wsMessages.GameControllerMessage;

public class GameController extends KeyAdapter {
    protected static boolean leftDirection = false;
	protected static boolean upDirection = false;
	private static boolean downDirection = false;
	private static boolean rightDirection = false;
	private static boolean isPlayer1;
	private static Session session;
		
		/**
		 * Listener for keyboard input: affects the ball position
		 * forcing the ball to move on either a horizontal or
		 * vertical slope 
		 */
        @Override
        public void keyPressed(KeyEvent e) {
        	//the idea is, when a player moves the ball, we want to 
        	//encode that movement and send it to the server
        	//so it can broadcast it to every player
            int key = e.getKeyCode();
			if(isPlayer1() == false) {
		
			if ((key == KeyEvent.VK_LEFT) && (!isLeftDirection())) {
                setLeftDirection(true);
                setUpDirection(false);
                setDownDirection(false);
                setRightDirection(false);
//                System.out.println("LEFT KEY");
            }

            if ((key == KeyEvent.VK_RIGHT) && (!isRightDirection())) {
                setRightDirection(true);
                setUpDirection(false);
                setDownDirection(false);
                setLeftDirection(false);
//                System.out.println("Right KEY");
            }
			}
			else {
            if ((key == KeyEvent.VK_UP) && (!isUpDirection())) {
                setUpDirection(true);
                setRightDirection(false);
                setLeftDirection(false);
                setDownDirection(false);
//                System.out.println("Up KEY");
            }

            if ((key == KeyEvent.VK_DOWN) && (!isDownDirection())) {
                setDownDirection(true);
                setRightDirection(false);
                setLeftDirection(false);
                setUpDirection(false);
//                System.out.println("Down KEY");
            }
			}
        	sendDirections();
        }
        /**
         * This function is used to broadcast the current direction
         * the player object should be moving to keep the game 
         * uniform for all players
         */
    	private void sendDirections() {
    		GameControllerMessage gameMsg = 
    				new GameControllerMessage(session.getId(),
    										  isLeftDirection(),
    										  isRightDirection(),
    										  isUpDirection(),
    										  isDownDirection());
    		try {
    			session.getBasicRemote().sendObject(gameMsg);
    		} catch (IOException | EncodeException | IllegalStateException e) {
    			System.err.println("Problem with sending a pickle-message.");
    		}
    		
    	}
    	
		public static boolean isLeftDirection() {
			return leftDirection;
		}

		public static void setLeftDirection(boolean leftDirection) {
			GameController.leftDirection = leftDirection;
		}

		public static boolean isRightDirection() {
			return rightDirection;
		}

		public static void setRightDirection(boolean rightDirection) {
			GameController.rightDirection = rightDirection;
		}

		public static boolean isUpDirection() {
			return upDirection;
		}

		public static void setUpDirection(boolean upDirection) {
			GameController.upDirection = upDirection;
		}

		public static boolean isDownDirection() {
			return downDirection;
		}

		public static void setDownDirection(boolean downDirection) {
			GameController.downDirection = downDirection;
		}
		
		/**
		 * This function will modify the controller based on what
		 * is passed thought he message object
		 * @param message the message object containing the boolean values
		 */
		public static void receivePoke(GameControllerMessage message) {
			setLeftDirection(message.isLeft());
			setRightDirection(message.isRight());
			setUpDirection(message.isUp());
			setDownDirection(message.isDown());
		}

		/**
		 * @return the session
		 */
		public static Session getSession() {
			return session;
		}

		/**
		 * @param session sets the session for gamecontroller to use
		 */
		public static void setSession(Session session) {
			GameController.session = session;
		}
		public static boolean isPlayer1() {
			return isPlayer1;
		}
		public static void setPlayer1(boolean isPlayer1) {
			GameController.isPlayer1 = isPlayer1;
		}
    }