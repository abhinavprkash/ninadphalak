
import java.util.*;

public class PermWithoutDups {

	public static void getPerms(String prefix, String remainder, ArrayList<String> result) {
		System.out.println("Remainder is: " + remainder.toString());
		if (remainder.length() == 0) {
			System.out.println("Prefix** is: " + prefix.toString());
			result.add(prefix);
		}
		int len = remainder.length();
		for (int i = 0; i < len; i++) {
			String before = remainder.substring(0, i);
			String after = remainder.substring(i + 1, len);
			char c = remainder.charAt(i);
			System.out.println("Prefix is: " + prefix.toString());
			System.out.println("Char c is: " + c);
			System.out.println("before is: " + before.toString() + " \nafter is : " + after.toString());
			System.out.println("------------------");
			getPerms(prefix + c, before + after, result);
		}
	}
	
	public static ArrayList<String> getPerms(String str) {
		ArrayList<String> result = new ArrayList<String>();
		getPerms("", str, result);
		return result;
	}
	
	public static void main(String[] args) {
		ArrayList<String> list = getPerms("abc");
		System.out.println("There are " + list.size() + " permutations.");
		for (String s : list) {
			System.out.println(s);
		}
	}

}