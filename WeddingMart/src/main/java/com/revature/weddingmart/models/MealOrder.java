package com.revature.weddingmart.models;

import java.util.Objects;

import com.revature.weddingmart.models.users.Attendee;

public class MealOrder {
	private Attendee attendee;
	private MealChoice lunchChoice;
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
		MealOrder other = (MealOrder) obj;
		return Objects.equals(attendee, other.attendee) && Objects.equals(dinnerChoice, other.dinnerChoice)
				&& Objects.equals(lunchChoice, other.lunchChoice);
	}

	@Override
	public String toString() {
		return "MealOrder [attendee=" + attendee + ", lunchChoice=" + lunchChoice + ", dinnerChoice=" + dinnerChoice
				+ "]";
	}

}
