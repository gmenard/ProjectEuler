package string;

/**
 * Tests for StringManipulation.java
 * 
 * @author Guillaume Menard
 */
public class Test {

	public static void main(String[] args) {
		

//		String res = StringManipulation.reverse("reversed");
		String res = StringManipulation.reverseWords("this sentence need to be reversed");
		
		System.out.println(res);
	}
}
