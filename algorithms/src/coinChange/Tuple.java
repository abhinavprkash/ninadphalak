package coinChange;

public class Tuple {
	
	int n;
	int idxFrom;
	public Tuple(int n, int indexFrom) {
		this.n = n;
		this.idxFrom = indexFrom;
	}
	
	@Override
	public boolean equals(Object other){
		if(!(other instanceof Tuple)){
			return false;
		}
		Tuple o = (Tuple)other;
		return ((this.n == o.n) && (this.idxFrom == o.idxFrom));
	}
	
	@Override
	public int hashCode(){
		int hashCode = 1;
		hashCode = 37 * hashCode + this.n + this.idxFrom;
		return hashCode;
	}
}
