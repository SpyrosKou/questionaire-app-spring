package eu.spyros.survey.model;

import javax.persistence.*;

@Entity
@Table(name = "customer_ride_feedback_request")
public class CustomerRideFeedbackRequest implements Identifiable {

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
	@JoinColumn(name = "ride_survey_id", referencedColumnName = "id")
	private RideSurvey rideSurvey;
	@OneToOne(mappedBy = "rideFeedbackRequest")
	private CustomerRideFeedbackResponse customerRideFeedback;


	public CustomerRideFeedbackRequest(Ride ride, RideSurvey rideSurvey) {
		this.ride = ride;
		this.rideSurvey = rideSurvey;
	}

	protected CustomerRideFeedbackRequest() {
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
	 * Getter for rideSurvey
	 *
	 * @return rideSurvey
	 **/
	public RideSurvey getRideSurvey() {
		return rideSurvey;
	}

	/**
	 * Setter for rideSurvey
	 *
	 * @param rideSurvey
	 **/
	public void setRideSurvey(RideSurvey rideSurvey) {
		this.rideSurvey = rideSurvey;
	}

	/**
	 * Getter for customerRideFeedback
	 *
	 * @return customerRideFeedback
	 **/
	public CustomerRideFeedbackResponse getCustomerRideFeedback() {
		return customerRideFeedback;
	}

	/**
	 * Setter for customerRideFeedback
	 *
	 * @param customerRideFeedback
	 **/
	public void setCustomerRideFeedback(CustomerRideFeedbackResponse customerRideFeedback) {
		this.customerRideFeedback = customerRideFeedback;
	}
}
