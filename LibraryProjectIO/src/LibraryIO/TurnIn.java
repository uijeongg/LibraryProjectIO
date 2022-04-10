package LibraryIO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.Scanner;

public class TurnIn {
	public static void doturnin(ArrayList<BookUser> booklist, ArrayList<BookAdmin> bookaddlist) {
		Scanner sc = new Scanner(System.in);
		int sum = 0; // 회원인지 아닌지 확인
		int a = 0; // 회원정보 인덱스를 담은 변수
		System.out.println("\n[로그인]");
		System.out.print("id를 입력하세요 : ");
		String id = sc.nextLine();
		System.out.print("비밀번호를 입력하세요 : ");
		String password = sc.nextLine();

		for (int i = 0; i < booklist.size(); i++) {
			if (booklist.get(i).getId().equals(id) && booklist.get(i).getPassword().equals(password)) {
				sum++;
				a = i;
			}
		}

		if (sum == 0) {
			System.out.println("[회원이 아닙니다]");

		} else {
			System.out.println("[회원입니다]");
			System.out.println("[도서 반납 창으로 이동합니다]");

			if (booklist.get(a).getBookhistory().equals("[대여]")) {

				System.out.println("\n===============================================");
				System.out.println("                <    도서 반납    >                 ");
				System.out.println("===============================================\n");

				Date today = new Date();
				String pattern = "yyyy-MM-dd(E)";
				SimpleDateFormat sdf = new SimpleDateFormat(pattern);
				String date = sdf.format(today);

				System.out.println("대여 날짜 : " + date);
				System.out.println("대여한 도서 이름 : " + booklist.get(a).getBookname());
				System.out.println("대여한 도서 지은이 : " + booklist.get(a).getBookwriter());

				System.out.println("반납처리 하시겠습니까? (Y/N)");
				String answer = sc.nextLine();

				if (answer.equals("Y")) {
					System.out.println("[반납처리 되었습니다]");
					booklist.add(new BookUser(id, password, "[대여 이력이 없습니다]", "[대여 이력이 없습니다]", "[대여 이력이 없습니다]",
							"[대여 이력이 없습니다]"));
					bookaddlist.add(new BookAdmin(booklist.get(a).getBookname(), booklist.get(a).getBookwriter()));
					booklist.remove(a);
				}

			} else {
				System.out.println("\n[도서 대여 이력이 없습니다]");
			}

		}

	}
}