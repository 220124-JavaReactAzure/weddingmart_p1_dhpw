package com.revature.weddingmart.models.users;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	@OneToOne(optional=false)
    @JoinColumn(name="type_id", unique=false, nullable=false, updatable=true)
	private User user;
	@Column(name = "is_manager")
	private boolean isManager;

	@Override
	public int hashCode() {
		return Objects.hash(isManager, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return isManager == other.isManager && Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return "Employee [user=" + user + ", isManager=" + isManager + "]";
	}

}
