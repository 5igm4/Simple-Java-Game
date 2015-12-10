package src.wsMessages;

import javax.json.Json;
import javax.json.JsonObject;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

public class EndGameEncoder implements Encoder.Text<EndGameMessage> {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(EndpointConfig arg0) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * This function builds the object
	 */
	@Override
	public String encode(EndGameMessage msg) throws EncodeException {
		JsonObject gameStart = Json.createObjectBuilder()
				.add("type","gameEnd")
                	.add("end", true)
                .build();
        return gameStart.toString();
	}

}
