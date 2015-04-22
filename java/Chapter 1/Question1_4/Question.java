package Question1_4;

public class Question {
	
	public static String reformatSpaces(String str) {
		StringBuilder strBuild = new StringBuilder(str.length());
		
		for (int i=0; i<str.length(); i++) {
			if (str.charAt(i) == ' ') {
				strBuild.append("%20");
			} else {
				strBuild.append(str.charAt(i));
			}
		}
		return strBuild.toString();
	}
	
	public static void main(String [] args) {
		String testStr = "Replace all the spaces in this string with %20 instead.";
		
		System.out.printf("%s\n", reformatSpaces(testStr));
	}
}

/*import CtCILibrary.AssortedMethods;

public class Question {
	// Assume string has sufficient free space at the end
	
	  public static void replaceSpaces(char[] str, int length) {
	 
		int spaceCount = 0, index, i = 0;
		for (i = 0; i < length; i++) {
			if (str[i] == ' ') {
				spaceCount++;
			}
		}
		index = length + spaceCount * 2;
		str[index] = '\0';
		for (i = length - 1; i >= 0; i--) {
			if (str[i] == ' ') {
				str[index - 1] = '0';
				str[index - 2] = '2';
				str[index - 3] = '%';
				index = index - 3;
			} else {
				str[index - 1] = str[i];
				index--;
			}
		}
	}
	
	public static void main(String[] args) {
		String str = "abc d e f";
		char[] arr = new char[str.length() + 3 * 2 + 1];
		for (int i = 0; i < str.length(); i++) {
			arr[i] = str.charAt(i);
		}
		replaceSpaces(arr, str.length());	
		System.out.println("\"" + AssortedMethods.charArrayToString(arr) + "\"");
	}
}*/
