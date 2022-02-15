package com.revature.weddingmart.models.users;

import java.util.Objects;

public class Employee {
	private User user;
	private boolean isManager;

	@Override
	public int hashCode() {
		return Objects.hash(isManager, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return isManager == other.isManager && Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return "Employee [user=" + user + ", isManager=" + isManager + "]";
	}

}
