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

    @ManyToOne(optional = false)
    @JoinColumn(name = "choice_question_id", referencedColumnName = "id")
    private ChoiceQuestion choiceQuestion;

    @ManyToOne(optional = false)
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
    private List<ChoiceQuestionOption> choosenOptions;

    protected ChoiceAnswer() {
    }

    /**
     * @param other
     * @param choiceQuestion
     * @param rideSurveyResponse
     * @param choosenOptions
     */
    private ChoiceAnswer(final String other, final ChoiceQuestion choiceQuestion, final RideSurveyResponse rideSurveyResponse, final List<ChoiceQuestionOption> choosenOptions) {
        Objects.requireNonNull(choiceQuestion);
        Objects.requireNonNull(rideSurveyResponse);
        Objects.requireNonNull(choosenOptions);

        this.other = other;
        this.choiceQuestion = choiceQuestion;
        this.rideSurveyResponse = rideSurveyResponse;
        this.choosenOptions = choosenOptions;
    }

    /**
     * @param other
     * @param choiceQuestion
     * @param rideSurveyResponse
     * @param selectedQuestionOption
     *
     * @return
     */
    public static final ChoiceAnswer createSingleChoiceAnswer(final String other, final ChoiceQuestion choiceQuestion, final RideSurveyResponse rideSurveyResponse, final ChoiceQuestionOption selectedQuestionOption) {
        Objects.requireNonNull(choiceQuestion);
        Objects.requireNonNull(rideSurveyResponse);
        Objects.requireNonNull(selectedQuestionOption);
        return new ChoiceAnswer(other, choiceQuestion, rideSurveyResponse, List.of(selectedQuestionOption));
    }

    /**
     * @param other
     * @param choiceQuestion
     * @param rideSurveyResponse
     * @param questionOptions
     */
    public static final ChoiceAnswer createMultipleChoiceAnswer(final String other, final ChoiceQuestion choiceQuestion, final RideSurveyResponse rideSurveyResponse, final List<ChoiceQuestionOption> questionOptions) {
        Objects.requireNonNull(choiceQuestion);
        Objects.requireNonNull(rideSurveyResponse);
        Objects.requireNonNull(questionOptions);

        return new ChoiceAnswer(other, choiceQuestion, rideSurveyResponse, questionOptions);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChoiceAnswer)) return false;
        ChoiceAnswer that = (ChoiceAnswer) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getOther(), that.getOther()) && Objects.equals(getChoiceQuestion(), that.getChoiceQuestion()) && Objects.equals(getRideSurveyResponse(), that.getRideSurveyResponse()) && Objects.equals(getChoosenOptions(), that.getChoosenOptions());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getOther(), getChoiceQuestion(), getRideSurveyResponse(), getChoosenOptions());
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
    public List<ChoiceQuestionOption> getChoosenOptions() {
        return choosenOptions;
    }

    /**
     * Setter for questionOptions
     *
     * @param questionOptions
     **/
    public void setChoosenOptions(List<ChoiceQuestionOption> questionOptions) {
        this.choosenOptions = questionOptions;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ChoiceAnswer.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("other='" + other + "'")
                .add("choiceQuestion=" + Identifiable.toString(choiceQuestion))
                .add("rideSurveyResponse=" + Identifiable.toString(rideSurveyResponse))
                .add("questionOptions=" + Identifiable.toString(choosenOptions))
                .toString();
    }
}
