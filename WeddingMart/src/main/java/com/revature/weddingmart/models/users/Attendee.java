package com.revature.weddingmart.models.users;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.revature.weddingmart.models.Wedding;

@Entity
@Table(name="attendee")
public class Attendee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column()
	private int id;
	@ManyToOne(optional=false)
	@OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name="user_id", unique=false, nullable=false, updatable=false)
	private User user;
	@ManyToOne(optional=false)
	@OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name="wedding_id", unique=false, nullable=false, updatable=true)
	private Wedding wedding;
	@Column(name = "rsvp_answer")
	private boolean rsvp;
	@Column(name = "plus_one_rsvp")
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
