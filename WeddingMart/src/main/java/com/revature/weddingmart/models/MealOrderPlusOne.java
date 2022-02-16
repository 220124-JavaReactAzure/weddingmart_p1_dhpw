package com.revature.weddingmart.models;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.revature.weddingmart.models.users.Attendee;

@Entity
@Table(name="meal_order_plus_one")
public class MealOrderPlusOne {
	@Id
	@GeneratedValue
	private long id;
	@OneToOne(optional=false)
    @JoinColumn(name="attendee_id", unique=false, nullable=false, updatable=true)
	private Attendee attendee;
	@ManyToOne(optional=true)
    @JoinColumn(name="lunch_choice", unique=false, nullable=true, updatable=true)
	private MealChoice lunchChoice;
	@ManyToOne(optional=true)
    @JoinColumn(name="dinner_choice", unique=false, nullable=true, updatable=true)
	private MealChoice dinnerChoice;

	public Attendee getAttendee() {
		return attendee;
	}

	public void setAttendee(Attendee attendee) {
		this.attendee = attendee;
	}

	public MealChoice getLunchChoice() {
		return lunchChoice;
	}

	public void setLunchChoice(MealChoice lunchChoice) {
		this.lunchChoice = lunchChoice;
	}

	public MealChoice getDinnerChoice() {
		return dinnerChoice;
	}

	public void setDinnerChoice(MealChoice dinnerChoice) {
		this.dinnerChoice = dinnerChoice;
	}

	@Override
	public int hashCode() {
		return Objects.hash(attendee, dinnerChoice, lunchChoice);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MealOrderPlusOne other = (MealOrderPlusOne) obj;
		return Objects.equals(attendee, other.attendee) && Objects.equals(dinnerChoice, other.dinnerChoice)
				&& Objects.equals(lunchChoice, other.lunchChoice);
	}

	@Override
	public String toString() {
		return "MealOrderPlusOne [attendee=" + attendee + ", lunchChoice=" + lunchChoice + ", dinnerChoice="
				+ dinnerChoice + "]";
	}

}
