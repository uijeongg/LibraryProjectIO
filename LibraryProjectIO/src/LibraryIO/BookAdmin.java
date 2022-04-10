package LibraryIO;

import java.util.Objects;

public class BookAdmin {
	private String bookname;
	private String bookwriter;

	public BookAdmin() {

	}

	public BookAdmin(String bookname, String bookwriter) {
		this.bookname = bookname;
		this.bookwriter = bookwriter;

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

	@Override
	public int hashCode() {
		return Objects.hash(bookname, bookwriter);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookAdmin other = (BookAdmin) obj;
		return Objects.equals(bookname, other.bookname) && Objects.equals(bookwriter, other.bookwriter);
	}

}
