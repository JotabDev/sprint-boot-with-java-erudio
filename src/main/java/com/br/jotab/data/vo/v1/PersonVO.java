package com.br.jotab.data.vo.v1;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id", "address", "firstName", "lastName"})
public class PersonVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
    @JsonProperty("first-name")
	private String firstName;

	private String LastName;

	private String Address;
	
	private String Gender;

	public PersonVO() {
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

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Address, Gender, LastName, firstName, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonVO other = (PersonVO) obj;
		return Objects.equals(Address, other.Address) && Objects.equals(Gender, other.Gender)
				&& Objects.equals(LastName, other.LastName) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(id, other.id);
	}

}
