package eu.spyros.survey.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * Drafted model of a ride. Assumes only on client per ride, no ridesharing.
 */
@Entity
@Table(name = "ride")
public class Ride implements Identifiable {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;


	@ManyToOne(optional = false)
	@JoinColumn(name = "customer_id", referencedColumnName = "id")
	private Customer customer;

	@OneToOne(mappedBy = "ride")
	private CustomerRideFeedbackRequest customerRideFeedbackRequest;

	/**
	 *
	 */
	protected Ride() {
	}

	/**
	 * @param customer
	 * @param customerRideFeedbackRequest
	 */
	public Ride(final Customer customer, final CustomerRideFeedbackRequest customerRideFeedbackRequest) {
		this.customer = customer;
		this.customerRideFeedbackRequest = customerRideFeedbackRequest;
	}

	/**
	 *
	 * @param customer
	 */
	public Ride(final Customer customer){
		this.customer = customer;
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
	 * Setter for id
	 *
	 * @param id
	 **/
	public void setId(final Long id) {
		this.id = id;
	}

	/**
	 * Getter for customer
	 *
	 * @return customer
	 **/
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * Setter for customer
	 *
	 * @param customer
	 **/
	public void setCustomer(final Customer customer) {
		this.customer = customer;
	}

	/**
	 * Getter for rideFeedbackRequest
	 *
	 * @return rideFeedbackRequest
	 **/
	public CustomerRideFeedbackRequest getCustomerRideFeedbackRequest() {
		return customerRideFeedbackRequest;
	}

	/**
	 * Setter for rideFeedbackRequest
	 *
	 * @param rideFeedbackRequest
	 **/
	public void setCustomerRideFeedbackRequest(final CustomerRideFeedbackRequest rideFeedbackRequest) {
		this.customerRideFeedbackRequest = rideFeedbackRequest;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Ride)) return false;
		Ride ride = (Ride) o;
		return getId().equals(ride.getId()) && getCustomer().equals(ride.getCustomer()) && Objects.equals(getCustomerRideFeedbackRequest(), ride.getCustomerRideFeedbackRequest());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getCustomer(), getCustomerRideFeedbackRequest());
	}


	@Override
	public String toString() {
		return new StringJoiner(", ", Ride.class.getSimpleName() + "[", "]")
				.add("id=" + id)
				.add("customer=" + Identifiable.toString(customer))
				.add("customerRideFeedbackRequest=" + Identifiable.toString(customerRideFeedbackRequest))
				.toString();
	}
}
