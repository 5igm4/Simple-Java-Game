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
		JsonObject jsonProdMessage = Json.createObjectBuilder()
				.add("type","pickle")
                .add("ID", msg.getID())
                .build();

        return jsonProdMessage.toString();
	}

}
