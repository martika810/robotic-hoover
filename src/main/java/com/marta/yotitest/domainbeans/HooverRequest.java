package com.marta.yotitest.domainbeans;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jettison.json.JSONException;

public class HooverRequest implements Jsonable {
	private int[] roomSize;
	private int[] coords;
	private int[][] patches;
	private String instructions;

	public int[] getRoomSize() {
		return roomSize;
	}

	public void setRoomSize(int[] roomSize) {
		this.roomSize = roomSize;
	}

	public int[] getCoords() {
		return coords;
	}

	public void setCoords(int[] coords) {
		this.coords = coords;
	}

	public int[][] getPatches() {
		return patches;
	}

	public void setPatches(int[][] patches) {
		this.patches = patches;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public String toJson() throws JSONException {
		try {
			return new ObjectMapper().writeValueAsString(this);
		} catch (IOException ex) {
			throw new JSONException(
					new StringBuilder("Error while converting ")
							.append(this.getClass().getName())
							.append("to json").toString());
		}
	}


}
