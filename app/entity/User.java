package entity;

import com.google.common.base.MoreObjects;

public class User {
	public int id;
	public String display_name;
	public String email;
	public String passwordhash;

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
			.add("id", id)
			.add("display_name", display_name)
			.add("email", email)
			.add("passwordhash", passwordhash)
			.toString();
	}
}
