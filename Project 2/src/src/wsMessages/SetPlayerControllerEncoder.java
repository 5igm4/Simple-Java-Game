package src.wsMessages;

import javax.json.Json;
import javax.json.JsonObject;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

public class SetPlayerControllerEncoder implements Encoder.Text<SetPlayerControllerMessage> {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(EndpointConfig arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String encode(SetPlayerControllerMessage msg) throws EncodeException {
		JsonObject setPlayer = Json.createObjectBuilder()
				.add("type","setPlayer")
                	.add("bool", true)
                .build();
        return setPlayer.toString();
	}

}
