package com.revature.weddingmart.models;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="wedding")
public class Wedding {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column()
	private int id;
	@Column()
	private double budget;
	@Column(name = "wedding_date")
	private Date weddingDate;
	@Column(name = "rsvp_by_date")
	private Date rsvpByDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}

	public Date getWeddingDate() {
		return weddingDate;
	}

	public void setWeddingDate(Date weddingDate) {
		this.weddingDate = weddingDate;
	}

	public Date getRsvpByDate() {
		return rsvpByDate;
	}

	public void setRsvpByDate(Date rsvpByDate) {
		this.rsvpByDate = rsvpByDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(budget, id, rsvpByDate, weddingDate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Wedding other = (Wedding) obj;
		return Double.doubleToLongBits(budget) == Double.doubleToLongBits(other.budget) && id == other.id
				&& Objects.equals(rsvpByDate, other.rsvpByDate) && Objects.equals(weddingDate, other.weddingDate);
	}

	@Override
	public String toString() {
		return "Wedding [id=" + id + ", budget=" + budget + ", weddingDate=" + weddingDate + ", rsvpByDate="
				+ rsvpByDate + "]";
	}

}
