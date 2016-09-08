package com.marta.yotitest.datastructure;

import com.marta.yotitest.domainbeans.Point;

public class RoomMatrixGraph implements RoomGraph,HooverControllerReceiver {
	private int[][] matrix;
	private int rows, columns;
	private int cleanedPatches;
	private Point hooverPosition;
	private static final int PATCH = 1;

	private RoomMatrixGraph() {
	}

	public static RoomGraph createinstance(int rows, int columns) {
		RoomMatrixGraph roomMatrix = new RoomMatrixGraph();
		roomMatrix.rows = rows;
		roomMatrix.columns = columns;
		roomMatrix.matrix = new int[rows][columns];
		roomMatrix.hooverPosition = Point.createInstance(0, 0);
		roomMatrix.cleanedPatches = 0;
		return roomMatrix;
		// for(int i = 0;i<rows;i++){
		// for(int j=0;j<columns;j++){
		// matrix[i][j] = 0;
		// }
		// }
	}
	
	public int getCleanedPatches(){
		return cleanedPatches;
	};
	
	public Point getHooverPosition(){
		return hooverPosition;
	}

	public void placeHoover(Point hooverPosition) {
		this.hooverPosition = hooverPosition;
	}
	
	public void clean(Point position){
		this.matrix[position.getX()][position.getY()] = 0;
	}

	public void addPatch(Point patchPosition) {
		if (patchPosition.getX() < rows && patchPosition.getY() < columns) {
			matrix[patchPosition.getX()][patchPosition.getY()] = PATCH;
		}
	}
	
	@Override
	public void addPatches(Point[] patchArray) {
		for(Point point: patchArray){
			addPatch(point);
		}
		
	}
	
	public boolean isPatch(Point position){
		if(position == null){
			return false;
		}
		return matrix[position.getX()][position.getY()] == PATCH;
	}
	
	public void moveHooverNorth(){
		if(hooverPosition.getY()+1<rows){
			hooverPosition = Point.createInstance(hooverPosition.getX(), hooverPosition.getY()+1);
			if(isPatch(hooverPosition)){
				cleanedPatches++;
				clean(hooverPosition);
			}
		}
		
	}
	
	public void moveHooverSouth(){
		if(hooverPosition.getY()-1<rows && hooverPosition.getY()-1>-1){
			hooverPosition = Point.createInstance(hooverPosition.getX(), hooverPosition.getY()-1);
			if(isPatch(hooverPosition)){
				cleanedPatches++;
				clean(hooverPosition);
			}
		}
	}
	public void moveHooverEast(){
		if(hooverPosition.getX()+1<columns){
			hooverPosition = Point.createInstance(hooverPosition.getX()+1, hooverPosition.getY());
			if(isPatch(hooverPosition)){
				cleanedPatches++;
				clean(hooverPosition);
			}
		}
		
	}
	public void moveHooverWest(){
		if(hooverPosition.getX()-1<columns && hooverPosition.getX()-1>-1){
			hooverPosition = Point.createInstance(hooverPosition.getX()-1, hooverPosition.getY());
			if(isPatch(hooverPosition)){
				cleanedPatches++;
				clean(hooverPosition);
			}
		}
		
	}

	

}
