import java.util.Scanner;

public class JavaApplication {

	public static int getWordsCount(String s) {

		if (s == null)
			return 0;

		int res = 0;

		String[] ss = s.split("\\s");
		for_tmp: for (String tmp : ss) {
			if (tmp.trim().length() == 0)
				continue;
			for (char c : tmp.toCharArray()) {
				if (!(c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z')) {
					continue for_tmp;
				}
			}
			res++;
		}
		return res;
	}

	public static void main(String[] args) {

		System.out.print("Enter text: ");
		String s = null;

		try (Scanner scanner = new Scanner(System.in);) {
			s = scanner.nextLine();
		}
		System.out.println(getWordsCount(s));
	}
}
