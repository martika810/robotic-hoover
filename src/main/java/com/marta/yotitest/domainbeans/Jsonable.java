package com.marta.yotitest.domainbeans;


import org.codehaus.jettison.json.JSONException;

public interface Jsonable<T> {
	public String toJson() throws JSONException;
}
