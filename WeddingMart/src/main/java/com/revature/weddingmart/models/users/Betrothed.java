package com.revature.weddingmart.models.users;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.revature.weddingmart.models.Wedding;

@Entity
@Table(name = "betrothed")
public class Betrothed {
	@Id
	@GeneratedValue
	private long id;
	@ManyToOne(optional = false)
	@JoinColumn(name = "user_email", unique = false, nullable = false, updatable = false)
	private User user;
	@ManyToOne(optional = false)
	@JoinColumn(name = "wedding_id", unique = false, nullable = false, updatable = false)
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
