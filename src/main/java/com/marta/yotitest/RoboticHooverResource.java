package com.marta.yotitest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.QueryParam;

import com.marta.yotitest.commands.Command;
import com.marta.yotitest.commands.MoveCommand;
import com.marta.yotitest.commands.MoveFactory;
import com.marta.yotitest.commands.PersistCommand;
import com.marta.yotitest.commands.SetupRoomCommand;
import com.marta.yotitest.datastructure.HooverControllerReceiver;
import com.marta.yotitest.datastructure.RoomGraph;
import com.marta.yotitest.domainbeans.HooverRequest;
import com.marta.yotitest.domainbeans.HooverResponse;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

@Path("/hoover")
public class RoboticHooverResource {
	
	@PUT
	public Response hoover(HooverRequest request) {

		//create the room with patches and hoover
		HooverResponse response = new HooverResponse();
		Command<HooverRequest,RoomGraph> setupCommand = new SetupRoomCommand();
		RoomGraph room = setupCommand.execute(request);
		
		//move the hoover following instructions
		List<MoveCommand> commands = MoveFactory.createCommands(request.getInstructions());
		
		for(MoveCommand command:commands){
			response =command.execute((HooverControllerReceiver)room);
		}
		
		//Save results
		Command<HooverResponse,HooverResponse> persistResultCommand = new PersistCommand();
		persistResultCommand.execute(response);
		
		return Response.ok(response).build();

	}

}
