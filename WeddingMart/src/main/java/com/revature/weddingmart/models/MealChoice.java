package com.revature.weddingmart.models;

import java.util.Objects;

public class MealChoice {
	private int id;
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
