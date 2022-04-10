package LibraryIO;

import java.util.Objects;

public class Member {
	private String name;
	private String identity;
	private String phonenumber;
	private String id;
	private String password;

	Member() {

	}

	Member(String name) {
		this.name = name;

	}

	Member(String name, String identity) {
		this.name = name;
		this.identity = identity;

	}

	Member(String name, String identity, String phonenumber, String id, String password) {
		this.name = name;
		this.identity = identity;
		this.phonenumber = phonenumber;
		this.id = id;
		this.password = password;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
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

	@Override
	public int hashCode() {
		return Objects.hash(id, identity, name, password, phonenumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		return Objects.equals(id, other.id) && Objects.equals(identity, other.identity)
				&& Objects.equals(name, other.name) && Objects.equals(password, other.password)
				&& Objects.equals(phonenumber, other.phonenumber);
	}

}
