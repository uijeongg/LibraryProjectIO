package LibraryIO;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Login {
	public static boolean dologin(ArrayList<Member> joinlist) {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		System.out.print("\n============로그인============\n");

		System.out.print("id를 입력하세요 : ");
		String id = sc.nextLine();
		System.out.print("비밀번호를 입력하세요 : ");
		String password = sc.nextLine();

		for (int i = 0; i < joinlist.size(); i++) {
			if (joinlist.get(i).getId().equals(id) && joinlist.get(i).getPassword().equals(password)) {
				sum++;
			}
		}

		if (sum == 1) {
			System.out.println("\n[로그인 되었습니다]");
			return true;
		} else {
			System.out.println("[회원이 아닙니다]");
			return false;
		}

	}
}