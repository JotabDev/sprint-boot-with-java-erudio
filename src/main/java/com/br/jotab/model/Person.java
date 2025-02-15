package com.br.jotab.model;

import java.io.Serializable;
import java.util.Objects;

public class Person implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String firstName;
	private String LastName;
	private String Andress;
	private String gender;

	public Person() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getAndress() {
		return Andress;
	}

	public void setAndress(String andress) {
		Andress = andress;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Andress, LastName, firstName, gender, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(Andress, other.Andress) && Objects.equals(LastName, other.LastName)
				&& Objects.equals(firstName, other.firstName) && Objects.equals(gender, other.gender)
				&& Objects.equals(id, other.id);
	}

}
