package eu.spyros.survey.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * Additional features omitted for brevity, an indication of the order of each question.
 */
@Entity
public class RideSurveyResponse implements Identifiable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToMany(mappedBy = "rideSurveyResponse")
	private List<FreeTextAnswer> freeTextAnswers;

	@OneToMany(mappedBy = "rideSurveyResponse")
	private List<ChoiceAnswer> choiceAnswers;

	@OneToOne
	@JoinColumn(name = "ride_feedback_request_id", referencedColumnName = "id")
	private CustomerRideFeedbackResponse customerRideFeedbackResponse;

	protected RideSurveyResponse() {
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
	 * Getter for freeTextAnswers
	 *
	 * @return freeTextAnswers
	 **/
	public List<FreeTextAnswer> getFreeTextAnswers() {
		return freeTextAnswers;
	}

	/**
	 * Setter for freeTextAnswers
	 *
	 * @param freeTextAnswers
	 **/
	public void setFreeTextAnswers(List<FreeTextAnswer> freeTextAnswers) {
		this.freeTextAnswers = freeTextAnswers;
	}

	/**
	 * Getter for choiceAnswers
	 *
	 * @return choiceAnswers
	 **/
	public List<ChoiceAnswer> getChoiceAnswers() {
		return choiceAnswers;
	}

	/**
	 * Setter for choiceAnswers
	 *
	 * @param choiceAnswers
	 **/
	public void setChoiceAnswers(List<ChoiceAnswer> choiceAnswers) {
		this.choiceAnswers = choiceAnswers;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof RideSurveyResponse)) return false;
		RideSurveyResponse that = (RideSurveyResponse) o;
		return Objects.equals(getId(), that.getId()) && Objects.equals(getFreeTextAnswers(), that.getFreeTextAnswers()) && Objects.equals(getChoiceAnswers(), that.getChoiceAnswers()) && Objects.equals(customerRideFeedbackResponse, that.customerRideFeedbackResponse);
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getFreeTextAnswers(), getChoiceAnswers(), customerRideFeedbackResponse);
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", RideSurveyResponse.class.getSimpleName() + "[", "]")
				.add("id=" + id)
				.add("freeTextAnswers=" + Identifiable.toString(freeTextAnswers))
				.add("choiceAnswers=" + Identifiable.toString(choiceAnswers))
				.add("customerRideFeedbackResponse=" + Identifiable.toString(customerRideFeedbackResponse))
				.toString();
	}
}
