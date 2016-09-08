package com.marta.yotitest.datastructure;

import com.marta.yotitest.domainbeans.Point;

public interface RoomGraph {
	
	public void addPatch(Point patchPosition);
	public void addPatches(Point patchArray[]);
	public void placeHoover(Point hooverPosition);
	public void clean(Point position);
	public int getCleanedPatches();
	public Point getHooverPosition();
	public boolean isPatch(Point position);
	
	

}
