package eu.spyros.survey.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * Created at 2021-05-08
 *
 * @author Spyros Koukas
 */
@Entity
@Table(name = "choice_question")
public class ChoiceQuestion implements Identifiable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String question;

    /**
     * Allows the user to specify how many options will be selected. For allowedSelections==1
     */
    private Integer allowedSelections;

    @ManyToOne
    @JoinColumn(name = "ride_survey_id", referencedColumnName = "id")
    private RideSurvey rideSurvey;

    @OneToMany(mappedBy = "choiceQuestion")
    private List<ChoiceQuestionOption> choiceQuestionOptions;

    protected ChoiceQuestion() {
    }


    /**
     * @param question
     * @param allowedSelections
     * @param rideSurvey
     * @param choiceQuestionOptions
     */
    private ChoiceQuestion(final String question, final Integer allowedSelections, final RideSurvey rideSurvey, final List<String> choiceQuestionOptions) {

        Objects.requireNonNull(question);
        Objects.requireNonNull(allowedSelections);
        Objects.requireNonNull(rideSurvey);
        Objects.requireNonNull(choiceQuestionOptions);

        this.question = question;
        this.allowedSelections = allowedSelections;
        this.rideSurvey = rideSurvey;

        final List<ChoiceQuestionOption> choiceQuestionOptionList = new ArrayList<>();
        int i = 1;
        for (final String option : choiceQuestionOptions) {
            choiceQuestionOptionList.add(new ChoiceQuestionOption(i++, option, this));
        }
        this.choiceQuestionOptions = choiceQuestionOptionList;

    }

    /**
     * Create a {@link ChoiceQuestion} that requires 1 single answer.
     * <p>
     *
     * @param question
     * @param rideSurvey
     * @param choiceQuestionOptions
     *
     * @return
     */
    public static final ChoiceQuestion createSingleChoice(final String question, final RideSurvey rideSurvey, final List<String> choiceQuestionOptions) {
        Objects.requireNonNull(question);
        Objects.requireNonNull(rideSurvey);
        Objects.requireNonNull(choiceQuestionOptions);
        return new ChoiceQuestion(question, 1, rideSurvey, choiceQuestionOptions);
    }

    /**
     * Create a {@link ChoiceQuestion} that requires a number of answers defined by allowedSelections.
     * This constructor can also be used to create a single choice question.
     *
     * @param question
     * @param allowedSelections
     * @param rideSurvey
     * @param choiceQuestionOptions
     *
     * @return
     */
    public static final ChoiceQuestion createMultipleChoice(final String question, final Integer allowedSelections, final RideSurvey rideSurvey, final List<String> choiceQuestionOptions) {

        Objects.requireNonNull(question);
        Objects.requireNonNull(allowedSelections);
        Objects.requireNonNull(rideSurvey);
        Objects.requireNonNull(choiceQuestionOptions);

        return new ChoiceQuestion(question, allowedSelections, rideSurvey, choiceQuestionOptions);
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
     * Getter for question
     *
     * @return question
     **/
    public String getQuestion() {
        return question;
    }

    /**
     * Setter for question
     *
     * @param question
     **/
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * Getter for allowedSelections
     *
     * @return allowedSelections
     **/
    public Integer getAllowedSelections() {
        return allowedSelections;
    }

    /**
     * Setter for allowedSelections
     *
     * @param allowedSelections
     **/
    public void setAllowedSelections(Integer allowedSelections) {
        this.allowedSelections = allowedSelections;
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
     * Getter for choiceQuestionOptions
     *
     * @return choiceQuestionOptions
     **/
    public List<ChoiceQuestionOption> getChoiceQuestionOptions() {
        return choiceQuestionOptions;
    }

    /**
     * Setter for choiceQuestionOptions
     *
     * @param choiceQuestionOptions
     **/
    public void setChoiceQuestionOptions(List<ChoiceQuestionOption> choiceQuestionOptions) {
        this.choiceQuestionOptions = choiceQuestionOptions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChoiceQuestion)) return false;
        ChoiceQuestion that = (ChoiceQuestion) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getQuestion(), that.getQuestion()) && Objects.equals(getAllowedSelections(), that.getAllowedSelections()) && Objects.equals(getRideSurvey(), that.getRideSurvey()) && Objects.equals(getChoiceQuestionOptions(), that.getChoiceQuestionOptions());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getQuestion(), getAllowedSelections(), getRideSurvey(), getChoiceQuestionOptions());
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return new StringJoiner(", ", ChoiceQuestion.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("question='" + question + "'")
                .add("allowedSelections=" + allowedSelections)
                .add("rideSurvey=" + Identifiable.toString(rideSurvey))
                .add("choiceQuestionOptions=" + Identifiable.toString(choiceQuestionOptions))
                .toString();
    }
}
