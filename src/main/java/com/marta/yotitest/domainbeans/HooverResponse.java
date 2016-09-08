package com.marta.yotitest.domainbeans;

import java.io.IOException;
import java.util.Arrays;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jettison.json.JSONException;

public class HooverResponse implements Jsonable {
	private int[] coords;
	private int patches;

	public int[] getCoords() {
		return coords;
	}

	public void setCoords(int[] coords) {
		this.coords = coords;
	}

	public int getPatches() {
		return patches;
	}

	public void setPatches(int patches) {
		this.patches = patches;
	}

	public static HooverResponse createInstance(int[] coords, int patches) {
		HooverResponse response = new HooverResponse();
		response.setCoords(coords);
		response.setPatches(patches);
		return response;
	}

	public String toJson() throws JSONException{
		try {
			return new ObjectMapper().writeValueAsString(this);
		} catch (IOException ex) {
			throw new JSONException(
					new StringBuilder("Error while converting ")
							.append(this.getClass().getName())
							.append("to json").toString());
		}
	}

	public static HooverResponse fromJson(String json) throws JSONException{
		try {
			return new ObjectMapper().readValue(json, HooverResponse.class);
		} catch (IOException e) {
			throw new JSONException(
					new StringBuilder("Error while converting ")
							.append(json)
							.append("to object").toString());
		}
	
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(coords);
		result = prime * result + patches;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof HooverResponse))
			return false;
		HooverResponse other = (HooverResponse) obj;
		if (!Arrays.equals(coords, other.coords))
			return false;
		if (patches != other.patches)
			return false;
		return true;
	}
	
	

}
