package eu.spyros.survey.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

/**
 *
 */
@Entity
@Table(name = "customer")
public class Customer implements Identifiable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String firstName;
	private String lastName;
	@OneToMany(mappedBy = "customer")
	private List<Ride> rides;

	/**
	 * Getter for rides
	 *
	 * @return rides
	 **/
	public List<Ride> getRides() {
		return rides;
	}

	/**
	 * Setter for rides
	 *
	 * @param rides
	 **/
	public void setRides(List<Ride> rides) {
		this.rides = rides;
	}


	protected Customer() {
	}

	public Customer(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Customer)) return false;
		Customer customer = (Customer) o;
		return Objects.equals(getId(), customer.getId()) && Objects.equals(getFirstName(), customer.getFirstName()) && Objects.equals(getLastName(), customer.getLastName()) && Objects.equals(getRides(), customer.getRides());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getFirstName(), getLastName(), getRides());
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", Customer.class.getSimpleName() + "[", "]")
				.add("id=" + id)
				.add("firstName='" + firstName + "'")
				.add("lastName='" + lastName + "'")
				.add("rides=" + Identifiable.toString(rides))
				.toString();
	}
}
