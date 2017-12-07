/*
public class brackets {

	public static StringBuilder printAllBrackets(int i, int j, StringBuilder sb){
		if(i == 0 && j == 0){
			System.out.println(sb.toString());
			return sb;
		}
		
		if(i==j){
			printAllBrackets(i-1, j, sb.append("("));
		}
		else if(i<j){
			printAllBrackets(i-1, j, sb.append("("));
			printAllBrackets(i, j-1, sb.append(")"));
		}
	}
	return sb;
}
*/