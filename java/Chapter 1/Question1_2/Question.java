package Question1_2;

public class Question {
	
	public static void reverse(char *head) {
		char *tail=head;
		while (*tail != null) {
			tail++;
		}
		
		char tmp;
		while (head != tail) {
			tmp = *head;
			*head = *tail;
			*tail = tmp;
			head++;
			tail--;
		}
	}
	
	public static void main(String[] args) {
		char testString[10] = "Hello worl";
		System.out.println("%s", testString);
	}
	
}