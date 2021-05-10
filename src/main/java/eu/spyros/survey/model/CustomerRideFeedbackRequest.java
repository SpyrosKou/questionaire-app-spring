package eu.spyros.survey.model;

import javax.persistence.*;

@Entity
@Table(name = "customer_ride_feedback_request")
public class CustomerRideFeedbackRequest implements Identifiable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne(optional = false)
	@JoinColumn(name = "ride_id", referencedColumnName = "id")
	private Ride ride;
	/**
	 * If null, no questionnaire needs to be answered by the user
	 * If not null, the specified questionnaire will be presented to the user
	 */
	@ManyToOne
	@JoinColumn(name = "ride_survey_id", referencedColumnName = "id")
	private RideSurvey rideSurvey;
	@OneToOne(mappedBy = "customerRideFeedbackRequest")
	private CustomerRideFeedbackResponse customerRideFeedbackResponse;


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
	@Override
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
	 * Getter for customerRideFeedbackResponse
	 *
	 * @return customerRideFeedbackResponse
	 **/
	public CustomerRideFeedbackResponse getCustomerRideFeedbackResponse() {
		return customerRideFeedbackResponse;
	}

	/**
	 * Setter for customerRideFeedbackResponse
	 *
	 * @param customerRideFeedbackResponse
	 **/
	public void setCustomerRideFeedbackResponse(CustomerRideFeedbackResponse customerRideFeedbackResponse) {
		this.customerRideFeedbackResponse = customerRideFeedbackResponse;
	}
}
