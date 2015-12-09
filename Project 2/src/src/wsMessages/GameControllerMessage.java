package src.wsMessages;

import gameClient.GameController;

public class GameControllerMessage extends Message  {
	String id;
	GameController controller;
	
	public GameControllerMessage(String id, GameController controller) {
		this.id = id;
		this.controller = controller;
	}

	public String getID() { return id; }
	
	public GameController getController() { return controller;}
}
