package Question1_5;

public class Question {
	
	public static String compressStr(String str) {
		StringBuilder strBld = new StringBuilder(str.length());
		int charRunCnt = 1;
				
		for (int i=1; i<str.length(); i++) {
			if (str.charAt(i-1) == str.charAt(i)) {
				charRunCnt++;
			} else {
				strBld.append(str.charAt(i-1));
				strBld.append(charRunCnt);
				charRunCnt = 1;
			}
		}
		strBld.append(str.charAt(str.length()-1));
		strBld.append(charRunCnt);
		
		return strBld.toString();
	}
	
	public static void main (String [] args) {
		String testStr = "aabcccccaaa";
		// should turn into a2b1c5a3
		//System.out.printf("Hello World!");
		System.out.printf("%s compressed is %s", testStr, compressStr(testStr));
	}
}

/*package Question1_5;

public class Question {

	public static int setChar(char[] array, char c, int index, int count) {
		array[index] = c;
		index++;
		char[] cnt = String.valueOf(count).toCharArray();
		for (char x : cnt) {
			array[index] = x;
			index++;
		}
		return index;
	}
	
	public static int countCompression(String str) {
		if (str == null || str.isEmpty()) return 0;
		char last = str.charAt(0);
		int size = 0;
		int count = 1;
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == last) {
				count++;
			} else {
				last = str.charAt(i);
				size += 1 + String.valueOf(count).length();
				count = 1;
			} 
		}
		size += 1 + String.valueOf(count).length();
		return size;
	}
	
	public static String compressBad(String str) {
		int size = countCompression(str);
		if (size >= str.length()) {
			return str;
		}
		String mystr = "";
		char last = str.charAt(0);
		int count = 1;
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == last) {
				count++;
			} else {
				mystr += last + "" + count;
				last = str.charAt(i);
				count = 1;
			}
		}
		return mystr + last + count;
	}
	
	public static String compressBetter(String str) {
		int size = countCompression(str);
		if (size >= str.length()) {
			return str;
		}
		StringBuffer mystr = new StringBuffer();
		char last = str.charAt(0);
		int count = 1;
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == last) {
				count++;
			} else {
				mystr.append(last);
				mystr.append(count);
				last = str.charAt(i);
				count = 1;
			}
		}
		mystr.append(last);
		mystr.append(count);
		return mystr.toString();
	}	
	
	public static String compressAlternate(String str) {
		int size = countCompression(str);
		if (size >= str.length()) {
			return str;
		}
		char[] array = new char[size];
		int index = 0;
		char last = str.charAt(0);
		int count = 1;
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == last) {
				count++;
			} else {
				index = setChar(array, last, index, count);
				last = str.charAt(i);
				count = 1;
			}
		}
		index = setChar(array, last, index, count);
		return String.valueOf(array);
	}
	
	public static void main(String[] args) {
		String str = "abbccccccde";
		int c = countCompression(str);
		String str2 = compressAlternate(str);
		String t = compressBetter("");
		System.out.println("Compression: " + t);
		System.out.println("Old String (len = " + str.length() + "): " + str);
		System.out.println("New String (len = " + str2.length() + "): " + str2);
		System.out.println("Potential Compression: " + c);
	}
}
*/