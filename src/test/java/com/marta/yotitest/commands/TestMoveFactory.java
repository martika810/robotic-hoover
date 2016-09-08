package com.marta.yotitest.commands;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

public class TestMoveFactory {
	
	@Test
	public void testFactory(){
		List<MoveCommand> commands = MoveFactory.createCommands("NNSSWW");
		assertEquals(6,commands.size());
		assertTrue(commands.get(0) instanceof MoveNorthCommand);
		assertTrue(commands.get(1) instanceof MoveNorthCommand);
		assertTrue(commands.get(2) instanceof MoveSouthCommand);
		assertTrue(commands.get(3) instanceof MoveSouthCommand);
		assertTrue(commands.get(4) instanceof MoveWestCommand);
		assertTrue(commands.get(5) instanceof MoveWestCommand);
	}
	
	@Test
	public void testFactoryEmptyCase(){

		List<MoveCommand> commands = MoveFactory.createCommands("");
		assertEquals(0,commands.size());
	
	}

	@Test
	public void testFactoryNullCase(){

		List<MoveCommand> commands = MoveFactory.createCommands(null);
		assertEquals(0,commands.size());
	
	}
}
