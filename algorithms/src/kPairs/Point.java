package kPairs;

public class Point implements Comparable<Point>{
	int x;
	int y;
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	@Override
	public int compareTo(Point o){
		int sum = this.x + this.y;
		int sumOther = o.x + o.y;
		if(sum < sumOther) return -1;
		else if(sum > sumOther) return 1;
		return 0;
	}
	
	@Override
	public String toString(){
		return new String("(" + this.x + "," + this.y + ")");
	}
}
