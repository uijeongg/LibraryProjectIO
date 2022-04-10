package LibraryIO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import java.io.IOException;

public class Join {
	public static void dojoin(ArrayList<Member> joinlist, ArrayList<BookUser> booklist) {

		Scanner sc = new Scanner(System.in);

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		FileReader fr; // 선언

		try {
			fr = new FileReader("userfolder\\user.txt");
			br = new BufferedReader(fr); // 초기화

			int sum = 0;

			System.out.println("\n===============================================");
			System.out.println("                 <    회원가입    >                 ");
			System.out.println("===============================================\n");
			System.out.print("이름을 입력하세요 : ");
			String name = sc.nextLine();
			System.out.print("주민번호를 - 없이 입력하세요 : ");
			String identity = sc.nextLine();
			System.out.print("휴대폰번호를 - 없이 입력하세요 : ");
			String phonenumber = sc.nextLine();
			System.out.print("ID를 입력하세요 : ");
			String id = sc.nextLine();
			System.out.print("비밀번호를 입력하세요 : ");
			String password = sc.nextLine();

			for (int i = 0; i < joinlist.size(); i++) {
				if ((joinlist.get(i).getName().equals(name) && joinlist.get(i).getIdentity().equals(identity))) {
					sum++;
				}
			}
			if (sum == 0) {
				joinlist.add(new Member(name, identity, phonenumber, id, password));

				booklist.add(
						new BookUser(id, password, "[대여 이력이 없습니다]", "[대여 이력이 없습니다]", "[대여 이력이 없습니다]", "[대여 이력이 없습니다]"));
				System.out.println("\n[회원가입이 완료되었습니다]");

				userFile(joinlist); // 회원 입력 정보를 가지고 감

				br.close();

			} else {
				System.out.println("[이미 회원입니다]");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void userFile(ArrayList<Member> joinlist) {

		FileWriter fw; // 파일을 써주겠다는 선언

		try {
			fw = new FileWriter("userfolder\\user.txt", true); // 파일 내용 이어써주기 true

			for (int i = 0; i < joinlist.size(); i++) {
				fw.write(" 회원 id : " + joinlist.get(i).getId() + "\r\n 회원 password : " + joinlist.get(i).getPassword()
						+ "\r\n 회원 주민번호 : " + joinlist.get(i).getIdentity() + "\r\n 회원 이름 :  "
						+ joinlist.get(i).getName() + "\r\n 회원 휴대폰번호 :  " + joinlist.get(i).getPhonenumber()
						+ "\r\n\r\n");

				// 포문으로 한사람 정보가 싹 들어가고 줄바꿈 후 또 포문 돌아감

			}
			fw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
