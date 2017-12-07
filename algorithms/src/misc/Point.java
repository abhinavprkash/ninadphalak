package misc;

import java.util.Comparator;

public class Point<K extends Comparable<? super K>,V extends Comparable<? super V>> implements Comparable<Point<K,V>> {
	K x;
	V y;
	
	public K getX() {
		return x;
	}

	public void setX(K x) {
		this.x = x;
	}

	public V getY() {
		return y;
	}

	public void setY(V y) {
		this.y = y;
	}

	public Point(K x1,V y1){
		this.x = x1;
		this.y = y1;
	}

	@Override
	public int compareTo(Point<K ,V > o) {
		if(this.x.compareTo(o.x) < 0){
			return -1;
		}
		else if(this.x.compareTo(o.x) > 1){
			return 1;
	     }
		else if(this.x.compareTo(o.x)==0){
			//x are equal, comapre y's
			return (this.y.compareTo(o.y) < 1)? -1 : 1;
		}
		return 0;//equal pairs
	}
	
	@Override
	public String toString(){
		String s = new String("(" +x + "," + y +")");
		return s;
	}
	
	
}
