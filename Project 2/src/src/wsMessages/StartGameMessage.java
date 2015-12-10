package src.wsMessages;

public class StartGameMessage extends Message{
	private boolean start; 
	
	public StartGameMessage(boolean start) {
		this.start = start;
	}

	public boolean didStart() { return start; }
}
