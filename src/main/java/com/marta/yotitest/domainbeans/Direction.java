package com.marta.yotitest.domainbeans;

public enum Direction {
	NORTH('N'),
	SOUTH('S'),
	EAST('E'),
	WEST('W');

	private final char direction;
	
	private Direction(char direction){
		this.direction =  direction;
	}
	
	public static Direction valueOf(char direction){
		if(direction == 'N'){
			return NORTH;
		}
		if(direction == 'S'){
			return SOUTH;
		}
		if(direction == 'E'){
			return EAST;
		}
		if(direction == 'W'){
			return WEST;
		}
		return null;
	}
}
