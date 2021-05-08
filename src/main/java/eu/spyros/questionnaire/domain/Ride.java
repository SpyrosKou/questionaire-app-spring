package eu.spyros.questionnaire.domain;

import javax.persistence.*;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * Drafted model of a ride. Assumes only on client per ride, no ridesharing.
 */
@Entity
@Table(name="ride")
public class Ride {


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="customer_id")
	private Customer customer;

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ride_feedback_request_id")
	private RideFeedbackRequest rideFeedbackRequest;

    /**
	 *
	 */
	protected Ride() {}

	/**
	 *
	 * @param customer
	 * @param rideFeedbackRequest
	 */
	public Ride(final Customer customer, final RideFeedbackRequest rideFeedbackRequest){
		this.customer=customer;
		this.rideFeedbackRequest=rideFeedbackRequest;
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
	public RideFeedbackRequest getRideFeedbackRequest() {
		return rideFeedbackRequest;
	}

	/**
	 * Setter for rideFeedbackRequest
	 *
	 * @param rideFeedbackRequest
	 **/
	public  void setRideFeedbackRequest(final RideFeedbackRequest rideFeedbackRequest) {
		this.rideFeedbackRequest = rideFeedbackRequest;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Ride)) return false;
		Ride ride = (Ride) o;
		return getId().equals(ride.getId()) && getCustomer().equals(ride.getCustomer()) && Objects.equals(getRideFeedbackRequest(), ride.getRideFeedbackRequest());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getCustomer(), getRideFeedbackRequest());
	}


	@Override
	public String toString() {
		return new StringJoiner(", ", Ride.class.getSimpleName() + "[", "]")
				.add("id=" + id)
				.add("customer=" + customer)
				.add("rideFeedbackRequest=" + rideFeedbackRequest)
				.toString();
	}
}
