package eu.spyros.survey.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * Created at 2021-05-08
 *
 * @author Spyros Koukas
 */
@Entity
@Table(name = "choice_answer")
public class ChoiceAnswer implements Identifiable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String other;

    @ManyToOne
    @JoinColumn(name = "choice_question_id", referencedColumnName = "id")
    private ChoiceQuestion choiceQuestion;

    @ManyToOne
    @JoinColumn(name = "ride_survey_response_id", referencedColumnName = "id")
    private RideSurveyResponse rideSurveyResponse;

    @ManyToMany
    @JoinTable(
            name = "choice_answer_options_to_questions",
            joinColumns =
            @JoinColumn(name = "choice_answer_id", referencedColumnName = "ID"),
            inverseJoinColumns =
            @JoinColumn(name = "choice_question_option_id", referencedColumnName = "ID")
    )
    private List<ChoiceQuestionOption> questionOptions;

    protected ChoiceAnswer() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChoiceAnswer)) return false;
        ChoiceAnswer that = (ChoiceAnswer) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getOther(), that.getOther()) && Objects.equals(getChoiceQuestion(), that.getChoiceQuestion()) && Objects.equals(getRideSurveyResponse(), that.getRideSurveyResponse()) && Objects.equals(getQuestionOptions(), that.getQuestionOptions());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getOther(), getChoiceQuestion(), getRideSurveyResponse(), getQuestionOptions());
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
     * Getter for choiceQuestion
     *
     * @return choiceQuestion
     **/
    public ChoiceQuestion getChoiceQuestion() {
        return choiceQuestion;
    }

    /**
     * Setter for choiceQuestion
     *
     * @param choiceQuestion
     **/
    public void setChoiceQuestion(ChoiceQuestion choiceQuestion) {
        this.choiceQuestion = choiceQuestion;
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
     * Getter for questionOptions
     *
     * @return questionOptions
     **/
    public List<ChoiceQuestionOption> getQuestionOptions() {
        return questionOptions;
    }

    /**
     * Setter for questionOptions
     *
     * @param questionOptions
     **/
    public void setQuestionOptions(List<ChoiceQuestionOption> questionOptions) {
        this.questionOptions = questionOptions;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ChoiceAnswer.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("other='" + other + "'")
                .add("choiceQuestion=" + Identifiable.toString(choiceQuestion))
                .add("rideSurveyResponse=" + Identifiable.toString(rideSurveyResponse))
                .add("questionOptions=" + Identifiable.toString(questionOptions))
                .toString();
    }
}
