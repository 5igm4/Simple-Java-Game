import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.ClientEndpoint;
import javax.websocket.OnOpen;
import javax.websocket.Session;

import wsMessages.Message;

import javax.websocket.DeploymentException;

/*
 * This object should serve both to listen to local control events (keyboard? mouse? whatever your game uses) and to receive control events from the WebSockets server.
 * (Actually, to receive ALL messages from the WS server.) Note that local control events should affect both the local "game board" and go to the server so the other player(s) boards
 * respond properly. You'll need to decide how to connect a GameController object with your game's GamePanel.
 *
 */

@ClientEndpoint
public class GameController implements ActionListener {

	@OnOpen
	public void onOpen(Session session) {

	}

	@OnMessage
	public void onMessage(Session session, Message message) {

	}

	@OnClose
	public void onClose(Session session, CloseReason closeReason) {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
