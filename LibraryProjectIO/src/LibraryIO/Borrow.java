package LibraryIO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.Scanner;

public class Borrow {
	public static void doborrow(ArrayList<BookUser> booklist, ArrayList<BookAdmin> bookaddlist) {
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
			System.out.println("[도서 대여 창으로 이동합니다]");

			if (booklist.get(a).getBookhistory().equals("[대여 이력이 없습니다]")) {

				Date today = new Date();
				String pattern = "yyyy-MM-dd(E)";
				SimpleDateFormat sdf = new SimpleDateFormat(pattern);
				String date = sdf.format(today);

				System.out.println("\n===============================================");
				System.out.println("                <    도서 대여    >                 ");
				System.out.println("===============================================\n");

				System.out.print("책 이름을 입력하세요 : ");
				String bookname = sc.nextLine();
				System.out.print("지은이를 입력하세요 : ");
				String bookwriter = sc.nextLine();

				for (int i = 0; i < bookaddlist.size(); i++) {
					if (bookaddlist.get(i).getBookname().equals(bookname)
							&& bookaddlist.get(i).getBookwriter().equals(bookwriter)) {
						System.out.println("['" + bookname + "'은(는) 대여 가능한 책입니다]");
						String bookhistory = "[대여]";
						booklist.add(new BookUser(id, password, bookname, bookwriter, date, bookhistory));
						booklist.remove(new BookUser(id, password, "[대여 이력이 없습니다]", "[대여 이력이 없습니다]", "[대여 이력이 없습니다]",
								"[대여 이력이 없습니다]"));
						bookaddlist.remove(i);

						System.out.println("대여하시겠습니까? (Y/N)");
						String answer1 = sc.nextLine();
						if (answer1.equals("Y")) {
							System.out.println("[" + date + " 날짜로 대여 처리되었습니다]");
						}

					} else {

					}
				}

			} else {
				System.out.println("\n[* caution *]");
				System.out.println("[현재 고객님은 대여 이력이 있으니 반납 후 진행해주십시오]\n");
			}
		}
	}

}