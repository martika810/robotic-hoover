package com.marta.yotitest.commands;

public interface Command<T1,R> {
	
	public R execute(T1 request);

}
