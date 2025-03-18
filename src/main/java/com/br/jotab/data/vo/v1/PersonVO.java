package com.br.jotab.data.vo.v1;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id", "firstName", "lastName", "Address", "Gender"})
public class PersonVO  extends RepresentationModel<PersonVO> implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("id")
	// @Mapping("id")
	private Long key;
    @JsonProperty("first-name")
	private String firstName;

	private String LastName;

	private String Address;
	
	private String Gender;

	public PersonVO() {
	}

	public Long getKey() {
		return key;
	}

	public void setKey(Long key) {
		this.key = key;
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
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(Address, Gender, LastName, firstName, key);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonVO other = (PersonVO) obj;
		return Objects.equals(Address, other.Address) && Objects.equals(Gender, other.Gender)
				&& Objects.equals(LastName, other.LastName) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(key, other.key);
	}

	

}
