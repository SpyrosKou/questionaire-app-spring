package eu.spyros.questionnaire.model;

import javax.persistence.*;

@Entity
@Table(name = "ride_feedback_request")
public class RideFeedbackRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne
	@JoinColumn(name = "ride_id", referencedColumnName = "id")
	private Ride ride;
	/**
	 * If null, no questionnaire needs to be answered by the user
	 * If not null, the specified questionnaire will be presented to the user
	 */
	@ManyToOne
	@JoinColumn(name = "ride_questionnaire_id", referencedColumnName = "id")
	private RideQuestionnaire rideQuestionnaire;
	@OneToOne(mappedBy = "rideFeedbackRequest")
	private CustomerRideFeedback customerRideFeedback;


	public RideFeedbackRequest(Ride ride, RideQuestionnaire rideQuestionnaire) {
		this.ride = ride;
		this.rideQuestionnaire = rideQuestionnaire;
	}

	protected RideFeedbackRequest() {
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
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Getter for ride
	 *
	 * @return ride
	 **/
	public Ride getRide() {
		return ride;
	}

	/**
	 * Setter for ride
	 *
	 * @param ride
	 **/
	public void setRide(Ride ride) {
		this.ride = ride;
	}

	/**
	 * Getter for rideQuestionnaire
	 *
	 * @return rideQuestionnaire
	 **/
	public RideQuestionnaire getRideQuestionnaire() {
		return rideQuestionnaire;
	}

	/**
	 * Setter for rideQuestionnaire
	 *
	 * @param rideQuestionnaire
	 **/
	public void setRideQuestionnaire(RideQuestionnaire rideQuestionnaire) {
		this.rideQuestionnaire = rideQuestionnaire;
	}

	/**
	 * Getter for customerRideFeedback
	 *
	 * @return customerRideFeedback
	 **/
	public CustomerRideFeedback getCustomerRideFeedback() {
		return customerRideFeedback;
	}

	/**
	 * Setter for customerRideFeedback
	 *
	 * @param customerRideFeedback
	 **/
	public void setCustomerRideFeedback(CustomerRideFeedback customerRideFeedback) {
		this.customerRideFeedback = customerRideFeedback;
	}
}
