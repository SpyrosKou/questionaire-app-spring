package eu.spyros.survey.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.StringJoiner;

/**
 *
 */
@Entity
@Table(name = "customer_ride_feedback_response")
public class CustomerRideFeedbackResponse implements Identifiable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //Using double so partial star ratings are available.
    private Double starRating;

    @OneToOne
    @JoinColumn(name = "customer_ride_feedback_request_id", referencedColumnName = "id")
    private CustomerRideFeedbackRequest customerRideFeedbackRequest;

    @OneToOne(mappedBy = "customerRideFeedbackResponse")
    private RideSurveyResponse rideSurveyResponse;

    public CustomerRideFeedbackResponse(Double starRating, CustomerRideFeedbackRequest customerRideFeedbackRequest) {
        Objects.requireNonNull(starRating);
        Objects.requireNonNull(customerRideFeedbackRequest);
        this.starRating = starRating;
        this.customerRideFeedbackRequest = customerRideFeedbackRequest;
    }

    protected CustomerRideFeedbackResponse() {
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
     * Getter for starRating
     *
     * @return starRating
     **/
    public Double getStarRating() {
        return starRating;
    }

    /**
     * Setter for starRating
     *
     * @param starRating
     **/
    public void setStarRating(Double starRating) {
        this.starRating = starRating;
    }

    /**
     * Getter for customerRideFeedbackRequest
     *
     * @return customerRideFeedbackRequest
     **/
    public CustomerRideFeedbackRequest getCustomerRideFeedbackRequest() {
        return customerRideFeedbackRequest;
    }

    /**
     * Setter for customerRideFeedbackRequest
     *
     * @param customerRideFeedbackRequest
     **/
    public void setCustomerRideFeedbackRequest(CustomerRideFeedbackRequest customerRideFeedbackRequest) {
        this.customerRideFeedbackRequest = customerRideFeedbackRequest;
    }

    /**
     * Getter for surveyResponse
     *
     * @return surveyResponse
     **/
    public RideSurveyResponse getRideSurveyResponse() {
        return rideSurveyResponse;
    }

    /**
     * Setter for surveyResponse
     *
     * @param surveyResponse
     **/
    public void setRideSurveyResponse(RideSurveyResponse surveyResponse) {
        this.rideSurveyResponse = surveyResponse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomerRideFeedbackResponse)) return false;
        CustomerRideFeedbackResponse that = (CustomerRideFeedbackResponse) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getStarRating(), that.getStarRating()) && Objects.equals(getCustomerRideFeedbackRequest(), that.getCustomerRideFeedbackRequest()) && Objects.equals(getRideSurveyResponse(), that.getRideSurveyResponse());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getStarRating(), getCustomerRideFeedbackRequest(), getRideSurveyResponse());
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CustomerRideFeedbackResponse.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("starRating=" + starRating)
                .add("customerRideFeedbackRequest=" + Identifiable.toString(customerRideFeedbackRequest))
                .add("surveyResponse=" + Identifiable.toString(rideSurveyResponse))
                .toString();
    }
}
