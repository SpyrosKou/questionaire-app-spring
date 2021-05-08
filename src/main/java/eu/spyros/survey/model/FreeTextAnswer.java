package eu.spyros.survey.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * An answer to a {@link FreeTextQuestion} of a specific {@link RideSurveyResponse} for particular {@link RideSurvey}
 * Created at 2021-05-08
 *
 * @author Spyros Koukas
 */
@Entity
@Table(name = "free_text_answer")
public class FreeTextAnswer implements Identifiable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String answer;
    private String other;

    @ManyToOne
    @JoinColumn(name = "ride_survey_response_id", referencedColumnName = "id")
    private RideSurveyResponse rideSurveyResponse;

    @ManyToOne
    @JoinColumn(name = "free_text_question_id", referencedColumnName = "id")
    private FreeTextQuestion freeTextQuestion;

    /**
     * @param answer
     * @param other
     * @param rideSurveyResponse
     * @param freeTextQuestion
     */
    public FreeTextAnswer(final String answer, final String other, final RideSurveyResponse rideSurveyResponse, final FreeTextQuestion freeTextQuestion) {
        this.answer = answer;
        this.other = other;
        this.rideSurveyResponse = rideSurveyResponse;
        this.freeTextQuestion = freeTextQuestion;
    }

    protected FreeTextAnswer() {
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
     * Getter for answer
     *
     * @return answer
     **/
    public String getAnswer() {
        return answer;
    }

    /**
     * Setter for answer
     *
     * @param answer
     **/
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    /**
     * Getter for other
     *
     * @return other
     **/
    public String getOther() {
        return other;
    }

    /**
     * Setter for other
     *
     * @param other
     **/
    public void setOther(String other) {
        this.other = other;
    }

    /**
     * Getter for rideSurveyResponse
     *
     * @return rideSurveyResponse
     **/
    public RideSurveyResponse getRideSurveyResponse() {
        return rideSurveyResponse;
    }

    /**
     * Setter for rideSurveyResponse
     *
     * @param rideSurveyResponse
     **/
    public void setRideSurveyResponse(RideSurveyResponse rideSurveyResponse) {
        this.rideSurveyResponse = rideSurveyResponse;
    }

    /**
     * Getter for freeTextQuestion
     *
     * @return freeTextQuestion
     **/
    public FreeTextQuestion getFreeTextQuestion() {
        return freeTextQuestion;
    }

    /**
     * Setter for freeTextQuestion
     *
     * @param freeTextQuestion
     **/
    public void setFreeTextQuestion(FreeTextQuestion freeTextQuestion) {
        this.freeTextQuestion = freeTextQuestion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FreeTextAnswer)) return false;
        FreeTextAnswer that = (FreeTextAnswer) o;
        return getId().equals(that.getId()) && Objects.equals(getAnswer(), that.getAnswer()) && Objects.equals(getOther(), that.getOther()) && getRideSurveyResponse().equals(that.getRideSurveyResponse()) && getFreeTextQuestion().equals(that.getFreeTextQuestion());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAnswer(), getOther(), getRideSurveyResponse(), getFreeTextQuestion());
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", FreeTextAnswer.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("answer='" + answer + "'")
                .add("other='" + other + "'")
                .add("rideSurveyResponse=" + Identifiable.toString(rideSurveyResponse))
                .add("freeTextQuestion=" + Identifiable.toString(freeTextQuestion))
                .toString();
    }
}
