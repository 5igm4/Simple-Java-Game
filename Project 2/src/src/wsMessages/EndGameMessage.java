package src.wsMessages;

public class EndGameMessage extends Message{
	private boolean end; 
	
	public EndGameMessage(boolean end) {
		this.end = end;
	}

	public boolean didStart() { return end; }
}
