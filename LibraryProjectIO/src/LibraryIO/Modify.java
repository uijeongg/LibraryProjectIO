package LibraryIO;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Modify {
	public static void domodify(ArrayList<Member> joinlist, ArrayList<BookUser> booklist) {

		Scanner sc = new Scanner(System.in);
		int sum = 0;

		System.out.println("\n[로그인]");
		System.out.print("id를 입력하세요 : ");
		String id = sc.nextLine();
		System.out.print("비밀번호를 입력하세요 : ");
		String password = sc.nextLine();

		for (int i = 0; i < joinlist.size(); i++) {
			if (joinlist.get(i).getId().equals(id) && joinlist.get(i).getPassword().equals(password)) {
				sum++;
			}
		}

		if (sum == 0) {
			System.out.println("[회원이 아닙니다]");
		} else {
			System.out.println("[회원입니다]");
			System.out.println("[변경 페이지로 넘어갑니다]");

//-------------------------------------------------------------------------

			System.out.println("\n================================================");
			System.out.println("              <    id/비밀번호 변경    >              ");
			System.out.println("================================================\n");

			System.out.print("id 변경: 1, 비밀번호 변경: 2를 선택하세요 : ");
			int num = sc.nextInt();

			if (num == 1) {
				sc.nextLine();

				System.out.println("\n=====================id 변경=====================\n");
				for (int i = 0; i < joinlist.size(); i++) {
					if (joinlist.get(i).getId().equals(id) && joinlist.get(i).getPassword().equals(password)) {
						System.out.print("새로운 id를 입력하세요 : ");
						String newId = sc.nextLine();
						joinlist.add(new Member(joinlist.get(i).getName(), joinlist.get(i).getIdentity(),
								joinlist.get(i).getPhonenumber(), newId, password));

						booklist.add(new BookUser(newId, password, booklist.get(i).getBookname(),
								booklist.get(i).getBookwriter(), booklist.get(i).getDate(),
								booklist.get(i).getBookhistory()));
						joinlist.remove(i);
						booklist.remove(i);

					}

				}
				System.out.println("\n[id가 변경되었습니다]");

			}

			if (num == 2) {
				sc.nextLine();
				System.out.println("\n===================비밀번호 변경===================\n");
				for (int i = 0; i < joinlist.size(); i++) {
					if (joinlist.get(i).getId().equals(id) && joinlist.get(i).getPassword().equals(password)) {

						System.out.print("새로운 비밀번호를 입력하세요 : ");
						String newPassword = sc.nextLine();
						joinlist.add(new Member(joinlist.get(i).getName(), joinlist.get(i).getIdentity(),
								joinlist.get(i).getPhonenumber(), id, newPassword));
						booklist.add(new BookUser(id, newPassword, booklist.get(i).getBookname(),
								booklist.get(i).getBookwriter(), booklist.get(i).getDate(),
								booklist.get(i).getBookhistory()));
						joinlist.remove(i);
						booklist.remove(i);

						System.out.println("\n[비밀번호가 변경되었습니다]");
					}
				}

			}
		}
	}
}
