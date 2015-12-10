package src.wsMessages;

public class GameControllerMessage extends Message  {
	String id;
	private boolean left;
	private boolean right;
	private boolean down;
	private boolean up;
	
	/**
	 * 
	 * @param id The identifier of the client
	 * @param left boolean to determine direction
	 * @param right boolean to determine direction
	 * @param up boolean to determine direction
	 * @param down boolean to determine direction
	 */
	public GameControllerMessage(
		String id, boolean left, boolean right, boolean up, boolean down) {
		
		this.id = id;
		this.setLeft(left);
		this.setRight(right);
		this.setUp(up);
		this.setDown(down);
		
	}

	public String getID() { return id; }

	/**
	 * @return the left
	 */
	public boolean isLeft() {
		return left;
	}

	/**
	 * @param left the left to set
	 */
	private void setLeft(boolean left) {
		this.left = left;
	}

	/**
	 * @return the right
	 */
	public boolean isRight() {
		return right;
	}

	/**
	 * @param right the right to set
	 */
	private void setRight(boolean right) {
		this.right = right;
	}

	/**
	 * @return the down
	 */
	public boolean isDown() {
		return down;
	}

	/**
	 * @param down the down to set
	 */
	private void setDown(boolean down) {
		this.down = down;
	}

	/**
	 * @return the up
	 */
	public boolean isUp() {
		return up;
	}

	/**
	 * @param up the up to set
	 */
	private void setUp(boolean up) {
		this.up = up;
	}
}
