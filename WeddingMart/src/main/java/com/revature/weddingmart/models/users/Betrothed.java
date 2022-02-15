package com.revature.weddingmart.models.users;

import java.util.Objects;

import com.revature.weddingmart.models.Wedding;

public class Betrothed {
	private User user;
	private Wedding wedding;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Wedding getWedding() {
		return wedding;
	}

	public void setWedding(Wedding wedding) {
		this.wedding = wedding;
	}

	@Override
	public int hashCode() {
		return Objects.hash(user, wedding);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Betrothed other = (Betrothed) obj;
		return Objects.equals(user, other.user) && Objects.equals(wedding, other.wedding);
	}

	@Override
	public String toString() {
		return "Betrothed [user=" + user + ", wedding=" + wedding + "]";
	}

}
