package com.marta.yotitest.domainbeans;

public class Point {
	private final int x;
	private final int y;
	
	private Point(int x,int y){
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public static Point createInstance(int x,int y){
		return new Point(x,y);
	}
	
	public static Point valueOf(int[] coords){
		if(coords ==null || coords.length<2 ){
			return createInstance(0, 0);
		}
		return createInstance(coords[0], coords[1]);
	}
	
	public int[] toArray(){
		int[] array = new int[2];
		array[0] = x;
		array[1] = y;
		return array;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Point)){
			return false;
		}
		Point other = (Point) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}	

}
