package com.marta.yotitest.commands;

import java.util.ArrayList;
import java.util.List;

import com.marta.yotitest.domainbeans.Direction;


public class MoveFactory {
	
	private MoveFactory(){}

	public static List<MoveCommand> createCommands(String instructions){
		List<MoveCommand> commands = new ArrayList<MoveCommand>();
		if(instructions == null) return commands;
		for(char direction: instructions.toCharArray()){
			if(Direction.NORTH.equals(Direction.valueOf(direction))){
				commands.add(new MoveNorthCommand());
			}
			if(Direction.SOUTH.equals(Direction.valueOf(direction))){
				commands.add(new MoveSouthCommand());
			}
			if(Direction.EAST.equals(Direction.valueOf(direction))){
				commands.add(new MoveEastCommand());
			}
			if(Direction.WEST.equals(Direction.valueOf(direction))){
				commands.add(new MoveWestCommand());
			}
		}
		return commands;
	}
}
