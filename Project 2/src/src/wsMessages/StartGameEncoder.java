package src.wsMessages;

import javax.json.Json;
import javax.json.JsonObject;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

public class StartGameEncoder implements Encoder.Text<StartGameMessage> {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(EndpointConfig arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String encode(StartGameMessage msg) throws EncodeException {
		JsonObject gameStart = Json.createObjectBuilder()
				.add("type","gameStart")
                	.add("start", true)
                .build();
        return gameStart.toString();
	}

}
