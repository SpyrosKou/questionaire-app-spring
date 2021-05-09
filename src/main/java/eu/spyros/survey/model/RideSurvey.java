package eu.spyros.survey.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * Additional features omitted for brevity, an indication of the order of each question.
 */
@Entity
public class RideSurvey implements Identifiable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToMany(mappedBy = "rideSurvey")
	private List<FreeTextQuestion> freeTextQuestions;

	@OneToMany(mappedBy = "rideSurvey")
	private List<ChoiceQuestion> choiceQuestions;

	public RideSurvey() {
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
	 * Getter for freeTextQuestions
	 *
	 * @return freeTextQuestions
	 **/
	public List<FreeTextQuestion> getFreeTextQuestions() {
		return freeTextQuestions;
	}

	/**
	 * Setter for freeTextQuestions
	 *
	 * @param freeTextQuestions
	 **/
	public void setFreeTextQuestions(List<FreeTextQuestion> freeTextQuestions) {
		this.freeTextQuestions = freeTextQuestions;
	}

	/**
	 * Getter for choiceQuestions
	 *
	 * @return choiceQuestions
	 **/
	public List<ChoiceQuestion> getChoiceQuestions() {
		return choiceQuestions;
	}

	/**
	 * Setter for choiceQuestions
	 *
	 * @param choiceQuestions
	 **/
	public void setChoiceQuestions(List<ChoiceQuestion> choiceQuestions) {
		this.choiceQuestions = choiceQuestions;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof RideSurvey)) return false;
		RideSurvey that = (RideSurvey) o;
		return Objects.equals(getId(), that.getId()) && Objects.equals(getFreeTextQuestions(), that.getFreeTextQuestions()) && Objects.equals(getChoiceQuestions(), that.getChoiceQuestions());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getFreeTextQuestions(), getChoiceQuestions());
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", RideSurvey.class.getSimpleName() + "[", "]")
				.add("id=" + id)
				.add("freeTextQuestions=" + Identifiable.toString(freeTextQuestions))
				.add("choiceQuestions=" + Identifiable.toString(choiceQuestions))
				.toString();
	}
}
