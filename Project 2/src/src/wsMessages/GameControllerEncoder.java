package src.wsMessages;

import javax.json.Json;
import javax.json.JsonObject;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

public class GameControllerEncoder  implements Encoder.Text<GameControllerMessage> {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(EndpointConfig arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String encode(GameControllerMessage msg) throws EncodeException {
		JsonObject gameController = Json.createObjectBuilder()
				.add("type","gameController")
                .add("ID", msg.getID())
                	.add("left", msg.isLeft())
                	.add("right", msg.isRight())
                	.add("up", msg.isUp())
                	.add("down", msg.isDown())
                .build();
		System.out.println(gameController.toString());
        return gameController.toString();
	}

}
