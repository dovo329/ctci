package Question1_1;

/**
 * @author douglas
 *
 */
/**
 * @author douglas
 *
 */
public class Question {

	public static boolean duplicateChars(String str) {
		boolean duplicate = false;
		boolean [] charUsed = new boolean[128]; // default initialized to false
		for (int i=0; i<str.length(); i++) {
			if (charUsed[str.charAt(i)]==true) {
				duplicate = true;
				//System.out.printf("hit the duplicate case\n");
			}
			//System.out.printf("str[%d]==%s or %d charUsed==%s\n", i, str.charAt(i), (int)str.charAt(i), charUsed[str.charAt(i)]?"true":"false");
			charUsed[str.charAt(i)] = true;
		}
		return duplicate;
	}
	

	public static void main (String[] args) {
		String[] testWords = {"apple", "gorge", "tale", "pole", "quail"};
		
		for (int i=0; i<testWords.length; i++) {
			//System.out.println("testWords["+i+"]=="+testWords[i]);
			System.out.printf("For testWords[%d]==%s there are %s duplicate characters\n", i,testWords[i], duplicateChars(testWords[i]) ? "indeed some" : "not any");
		}
	}
	
	/*
	public static boolean isUniqueChars(String str) {
		if (str.length() > 128) {
			return false;
		}
		int checker = 0;
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i) - 'a';
			if ((checker & (1 << val)) > 0) return false;
			checker |= (1 << val);
		}
		return true;
	}
	
	public static boolean isUniqueChars2(String str) {
		if (str.length() > 128) {
			return false;
		}
		boolean[] char_set = new boolean[128];
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
			if (char_set[val]) return false;
			char_set[val] = true;
		}
		return true;
	}
	
	public static void main(String[] args) {
		String[] words = {"abcde", "hello", "apple", "kite", "padle"};
		for (String word : words) {
			System.out.println(word + ": " + isUniqueChars(word) + " " + isUniqueChars2(word));
		}
	}
*/
}
