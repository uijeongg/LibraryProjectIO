package LibraryIO;

import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//책 입력
public class Admin {
	void bookadd(ArrayList<BookAdmin> bookaddlist) {

		Scanner sc = new Scanner(System.in);

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		FileReader fr; // 선언

		try {
			fr = new FileReader("bookaddfolder\\bookadd.txt");
			br = new BufferedReader(fr); // 초기화

			System.out.println("\n===============================================");
			System.out.println("                <    도서 입력    >                 ");
			System.out.println("===============================================\n");

			a: while (true) {

				System.out.print("\n도서 이름을 입력하세요 : ");
				String bookname = sc.nextLine();
				System.out.print("지은이를 입력하세요 : ");
				String bookwriter = sc.nextLine();

				System.out.println("\n입력한 도서의 정보가 모두 맞습니까? (Y / N)");
				String answer1 = sc.nextLine();

				if (answer1.equals("Y")) {
					BookAdmin book = new BookAdmin();
					book.setBookname(bookname);
					book.setBookwriter(bookwriter);
					bookaddlist.add(book);

					bookaddFile(bookaddlist); // bookaddlist 정보를 가지고 bookaddFile로 감
					br.close();

					System.out.println("['" + bookname + "'이(가) 정상적으로 입력되었습니다]\n");

					System.out.println("< 입력된 도서 총 목록 >");
					for (int i = 0; i < bookaddlist.size(); i++) {
						System.out.println(bookaddlist.get(i).getBookname());
					}

					System.out.println("\n도서를 추가 입력 하시겠습니까? (Y / N)");
					String answer2 = sc.nextLine();

					if (answer2.equals("Y")) {
						continue a;

					} else {
						break;

					}

				}

			}
			System.out.println("[도서 입력 서비스가 종료되었습니다]\n");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void bookaddFile(ArrayList<BookAdmin> bookaddlist) {

		FileWriter fw;

		try {
			fw = new FileWriter("bookaddfolder\\bookadd.txt", true); // 파일 내용 이어써주기 true

			for (int i = 0; i < bookaddlist.size(); i++) {
				fw.write(" 도서명 : " + bookaddlist.get(i).getBookname() + "\r\n 지은이 : "
						+ bookaddlist.get(i).getBookwriter() + "\r\n\r\n");

			}
			fw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
