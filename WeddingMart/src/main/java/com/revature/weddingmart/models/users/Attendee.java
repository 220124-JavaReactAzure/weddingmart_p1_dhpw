package com.revature.weddingmart.models.users;

import java.util.Objects;

import com.revature.weddingmart.models.Wedding;

public class Attendee {
	private int id;
	private User user;
	private Wedding wedding;
	private boolean rsvp;
	private boolean rsvpPlusOne;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public boolean isRsvp() {
		return rsvp;
	}

	public void setRsvp(boolean rsvp) {
		this.rsvp = rsvp;
	}

	public boolean isRsvpPlusOne() {
		return rsvpPlusOne;
	}

	public void setRsvpPlusOne(boolean rsvpPlusOne) {
		this.rsvpPlusOne = rsvpPlusOne;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, rsvp, rsvpPlusOne, user, wedding);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Attendee other = (Attendee) obj;
		return id == other.id && rsvp == other.rsvp && rsvpPlusOne == other.rsvpPlusOne
				&& Objects.equals(user, other.user) && Objects.equals(wedding, other.wedding);
	}

	@Override
	public String toString() {
		return "Attendee [id=" + id + ", user=" + user + ", wedding=" + wedding + ", rsvp=" + rsvp + ", rsvpPlusOne="
				+ rsvpPlusOne + "]";
	}

}
