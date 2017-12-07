package misc;


 public class Interval implements Comparable<Interval> {
     int start;
     int end;
     Interval() { start = 0; end = 0; }
     Interval(int s, int e) { start = s; end = e; }
     
     
	@Override
	public int compareTo(Interval o) {
		if(this.start < o.start) return -1;
		else if (this.start > o.start) return 1;
		return 0;
	}
	
	@Override
	public String toString(){
		return new String("(" + start + "," + end + ")");
	}
 }
