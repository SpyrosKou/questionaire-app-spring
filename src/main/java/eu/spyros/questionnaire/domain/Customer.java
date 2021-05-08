package eu.spyros.questionnaire.domain;

import javax.persistence.*;

@Entity
@Table(name="customer")
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String firstName;
	private String lastName;

	protected Customer() {}

	public Customer(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return String.format(
				"Customer[id=%d, firstName='%s', lastName='%s']",
				id, firstName, lastName);
	}

	/**
	 * Getter for id
	 *
	 * @return id
	 **/
	public Long getId() {
		return id;
	}

	/**
	 * Getter for firstName
	 *
	 * @return firstName
	 **/
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Getter for lastName
	 *
	 * @return lastName
	 **/
	public String getLastName() {
		return lastName;
	}

	/**
	 * Setter for id
	 *
	 * @param id
	 **/
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Setter for firstName
	 *
	 * @param firstName
	 **/
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Setter for lastName
	 *
	 * @param lastName
	 **/
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
