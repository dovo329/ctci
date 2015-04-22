package Question1_3;

import java.util.Arrays;

public class Question {
	public static boolean isPermutation(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false;
		}
			
		// better to sort the strings and compare than to count occurances of characters as unicode could have very many characters taking up too much memory
/*		int [] str1CharCnt = new int[128];
		Arrays.fill(str1CharCnt, 0);
		int [] str2CharCnt = new int[128];
		Arrays.fill(str2CharCnt, 0);
		
		for (int i=0; i<str1.length; i++) {
			str1.charAt(i);
		}*/
		char [] charArr1 = str1.toCharArray();
		char [] charArr2 = str2.toCharArray();
		
		System.out.printf("Presort str1=%s, str2=%s\n", str1, str2);
		Arrays.sort(charArr1);
		Arrays.sort(charArr2);
		String sortedStr1 = new String(charArr1);
		String sortedStr2 = new String(charArr2);
		System.out.printf("Postsort str1=%s, str2=%s\n", sortedStr1, sortedStr2);
		return sortedStr1.equals(sortedStr2);
	}
	
	public static void main(String[] args) {
		String str1 = "Permutation string";
		String str2 = "Pi seinrontatmuIrg";
		System.out.printf("str1 %s a permutation of str2\n", isPermutation(str1, str2) ? "is indeed" : "is not");
		
		String str3 = "Permutation string";
		String str4 = "eu sttrmngratPioni";
		System.out.printf("str3 %s a permutation of str4\n", isPermutation(str3, str4) ? "is indeed" : "is not");
	}
	
/*	public static String sort(String s) {
		char[] content = s.toCharArray();
		java.util.Arrays.sort(content);
		return new String(content);
	}
	
	public static boolean permutation(String s, String t) {
		return sort(s).equals(sort(t));
	}
	
	public static boolean anagram(String s, String t) {
		if (s.length() != t.length())
			return false;
		int[] letters = new int[128];
		int num_unique_chars = 0;
		int num_completed_t = 0;
		char[] s_array = s.toCharArray();
		for (char c : s_array) { // count number of each char in s.
			if (letters[c] == 0)
				++num_unique_chars;
			++letters[c];
		}
		for (int i = 0; i < t.length(); ++i) {
			int c = (int) t.charAt(i);
			if (letters[c] == 0) { // Found more of char c in t than in s.
				return false;
			}
			--letters[c];
			if (letters[c] == 0) {
				++num_completed_t;
				if (num_completed_t == num_unique_chars) {
					// it�s a match if t has been processed completely
					return true;
					//return i == t.length() - 1;
				}
			}
		}
		return false;
	}	
	
	public static void main(String[] args) {
		String[][] pairs = {{"apple", "papel"}, {"carrot", "tarroc"}, {"hello", "llloh"}};
		for (String[] pair : pairs) {
			String word1 = pair[0];
			String word2 = pair[1];
			boolean anagram = permutation(word1, word2);
			System.out.println(word1 + ", " + word2 + ": " + anagram);
			System.out.println(anagram(word1, word2));
		}
	}
	*/
}
