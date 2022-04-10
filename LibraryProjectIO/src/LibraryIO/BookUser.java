package LibraryIO;
import java.util.Objects;

public class BookUser {
	private String id;
	private String password;
	private String bookname;	
	private String bookwriter;
	private String date;
	private String bookhistory; //회원이 책을 빌렸다 안빌렸다가 히스토리에 남음

	public BookUser() {
		
	}
	
	
	public BookUser(String id, String password, String bookname, String bookwriter, String date, String bookhistory) {
		super();
		this.id = id;
		this.password = password;
		this.bookname = bookname;
		this.bookwriter=bookwriter;
		this.date = date;
		this.bookhistory = bookhistory;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getBookname() {
		return bookname;
	}


	public void setBookname(String bookname) {
		this.bookname = bookname;
	}


	public String getBookwriter() {
		return bookwriter;
	}


	public void setBookwriter(String bookwriter) {
		this.bookwriter = bookwriter;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getBookhistory() {
		return bookhistory;
	}


	public void setBookhistory(String bookhistory) {
		this.bookhistory = bookhistory;
	}


	@Override
	public int hashCode() {
		return Objects.hash(bookhistory, bookname, bookwriter, date, id, password);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookUser other = (BookUser) obj;
		return Objects.equals(bookhistory, other.bookhistory) && Objects.equals(bookname, other.bookname)
				&& Objects.equals(bookwriter, other.bookwriter) && Objects.equals(date, other.date)
				&& Objects.equals(id, other.id) && Objects.equals(password, other.password);
	}



	
}