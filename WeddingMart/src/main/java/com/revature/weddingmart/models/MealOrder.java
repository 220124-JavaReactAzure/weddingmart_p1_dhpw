package com.revature.weddingmart.models;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.revature.weddingmart.models.users.Attendee;

@Entity
@Table(name = "meal_order")
public class MealOrder {
	@Id
	@GeneratedValue
	private long id;
	@OneToOne(optional = false, cascade = CascadeType.ALL)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "attendee_id", unique = false, nullable = false, updatable = true)
	private Attendee attendee;
	@ManyToOne(optional = true, cascade = CascadeType.ALL)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "meal_choice", unique = false, nullable = true, updatable = true)
	private MealChoice mealChoice;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Attendee getAttendee() {
		return attendee;
	}

	public void setAttendee(Attendee attendee) {
		this.attendee = attendee;
	}

	public MealChoice getMealChoice() {
		return mealChoice;
	}

	public void setMealChoice(MealChoice mealChoice) {
		this.mealChoice = mealChoice;
	}

	@Override
	public int hashCode() {
		return Objects.hash(attendee, id, mealChoice);
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
		return Objects.equals(attendee, other.attendee) && id == other.id
				&& Objects.equals(mealChoice, other.mealChoice);
	}

	@Override
	public String toString() {
		return "MealOrder [id=" + id + ", attendee=" + attendee + ", mealChoice=" + mealChoice + "]";
	}

}
