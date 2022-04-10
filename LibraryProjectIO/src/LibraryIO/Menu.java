package LibraryIO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Menu {
	public void menu1() {
		Scanner sc = new Scanner(System.in);

		ArrayList<Member> joinlist = new ArrayList<>();
		ArrayList<BookUser> booklist = new ArrayList<>();
		ArrayList<BookAdmin> bookaddlist = new ArrayList<>();

		joinlist.add(new Member("정길동", "9701012000000", "01011111111", "jeong", "0000"));
		booklist.add(new BookUser("jeong", "0000", "[대여 이력이 없습니다]", "[대여 이력이 없습니다]", "[대여 이력이 없습니다]", "[대여 이력이 없습니다]"));
		bookaddlist.add(new BookAdmin("난중일기", "이순신"));

		System.out.println("\n=================================================");
		System.out.println("=================================================");
		System.out.println("             WELLCOME TO KOPO LIBRARY             ");
		System.out.println("=================================================");
		System.out.println("=================================================\n");

		System.out.println("*******************");
		System.out.println("1. 회원가입");
//		System.out.println("2. 회원 로그인"); 각 창마다 로그인 먼저 하게 하므로 여기선 뺌
		System.out.println("2. 아이디/비밀번호 변경");
		System.out.println("3. 책 대여하기");
		System.out.println("4. 책 반납하기");
		System.out.println("5. 종료");
		System.out.println("0. 관리자 모드");
		System.out.print("*******************\n\n");

		a: while (true) {

			System.out.print("원하시는 서비스의 번호를 입력하세요 : ");

			switch (sc.nextInt()) {

			// join class : 회원가입
			case 1:
				Join.dojoin(joinlist, booklist);
				sc.nextLine();
				System.out.print("\n계속: Y , 종료: N을 선택하세요 : ");
				if (sc.nextLine().equals("Y")) {
					break;
				} else {
					break a;
				}

				// login class : 로그인
				/*
				 * case 2: Login.dologin(joinlist); // 종료 Y는 케이스문마다 다 있어야함 sc.nextLine();
				 * System.out.print("\n계속: Y , 종료: N을 선택하세요 : "); if (sc.nextLine().equals("Y"))
				 * { break; } else { break a; }
				 */

				// modify class : 아이디 비번 수정
			case 2:
				Modify.domodify(joinlist, booklist);
				sc.nextLine(); // 버퍼비우기
				System.out.print("\n계속: Y , 종료: N을 선택하세요 : ");
				if (sc.nextLine().equals("Y")) {
					break;
				} else {
					break a;
				}

				// borrow class : 책 대여
			case 3:
				Borrow.doborrow(booklist, bookaddlist);
				sc.nextLine();
//				System.out.print("\n계속: Y , 종료: N을 선택하세요 : ");
//				if (sc.nextLine().equals("Y")) {
//					break;
//				} else {
//					break a;
//				}
				System.out.println("\n[대여 서비스가 종료되었습니다]");
				break;

			// turnin class : 책 반납
			case 4:
				TurnIn.doturnin(booklist, bookaddlist);
				sc.nextLine();
				System.out.print("\n계속: Y , 종료: N을 선택하세요 : ");
				if (sc.nextLine().equals("Y")) {
					break;
				} else {
					break a;
				}

				// 종료
			case 5:
				break a;

			case 0:
				System.out.print("\n관리자 비밀번호 4자리를 입력하세요: ");
				sc.nextLine();
				int adminInput = Integer.parseInt(sc.nextLine());

				if (adminInput == 1234) {
					System.out.println("[관리자 로그인되었습니다]");
					Admin ad = new Admin();
					ad.bookadd(bookaddlist);

					break;

				} else {
					System.out.println("[비밀번호가 틀렸습니다]");
					break a;

				}

			}
		}
		System.out.println("\n[서비스가 종료되었습니다]");
	}
}
