package com.revature.weddingmart.models;

import java.util.Date;
import java.util.Objects;

public class Wedding {
	private int id;
	private double budget;
	private Date weddingDate;
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
