package com.marta.yotitest.commands;

import com.marta.yotitest.datastructure.HooverControllerReceiver;
import com.marta.yotitest.domainbeans.HooverResponse;

public interface MoveCommand {
	
	public HooverResponse execute(HooverControllerReceiver roomInformation);

}
