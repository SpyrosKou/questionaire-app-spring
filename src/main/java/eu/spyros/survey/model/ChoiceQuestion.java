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
