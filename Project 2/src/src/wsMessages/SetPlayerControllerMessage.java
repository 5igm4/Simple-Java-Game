package src.wsMessages;

/**
 * This class is what differentiates between player 1 and 2
 * The first client to connect is going to be sent this message with
 * the boolean set to true, and the second client to connect will 
 * receive a boolean value of false.
 * @author Robert
 *
 */
public class SetPlayerControllerMessage extends Message {
	private boolean setPlayer; 
	
	public SetPlayerControllerMessage(boolean setPlayer) {
		this.setPlayer = setPlayer;
	}

	public boolean setPlayer() { return setPlayer; }
}
