package com.revature.weddingmart.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="meal_choice")
public class MealChoice {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column()
	private int id;
	@Column(unique=true)
	private String description;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MealChoice other = (MealChoice) obj;
		return Objects.equals(description, other.description) && id == other.id;
	}

	@Override
	public String toString() {
		return "MealChoice [id=" + id + ", description=" + description + "]";
	}

}
