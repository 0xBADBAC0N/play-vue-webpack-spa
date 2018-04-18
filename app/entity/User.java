package entity;

import com.google.common.base.MoreObjects;

public class User {
	public int id;

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
			.add("id", id)
			.toString();
	}
}
