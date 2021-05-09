package eu.spyros.survey.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * Created at 2021-05-08
 *
 * @author Spyros Koukas
 */
@Entity
@Table(name = "question_option")
public class ChoiceQuestionOption implements Identifiable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * The sequence of appearance to the user
     */
    private Integer sequence;
    /**
     * Option textual description
     */
    private String option;
    @ManyToOne(optional = false)
    @JoinColumn(name = "choice_question_id", referencedColumnName = "id")
    private ChoiceQuestion choiceQuestion;


    /**
     * @param sequence
     * @param option
     * @param choiceQuestion
     */
    public ChoiceQuestionOption(Integer sequence, String option, ChoiceQuestion choiceQuestion) {
        Objects.requireNonNull(sequence);
        Objects.requireNonNull(option);
        Objects.requireNonNull(choiceQuestion);
        this.sequence = sequence;
        this.option = option;
        this.choiceQuestion = choiceQuestion;
    }

    /**
     * @param sequence
     * @param option
     */
    public ChoiceQuestionOption(Integer sequence, String option) {
        Objects.requireNonNull(sequence);
        Objects.requireNonNull(option);
        this.sequence = sequence;
        this.option = option;

    }

    /**
     *
     */
    protected ChoiceQuestionOption() {

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
     * Getter for sequence
     *
     * @return sequence
     **/
    public Integer getSequence() {
        return sequence;
    }

    /**
     * Setter for sequence
     *
     * @param sequence
     **/
    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    /**
     * Getter for option
     *
     * @return option
     **/
    public String getOption() {
        return option;
    }

    /**
     * Setter for option
     *
     * @param option
     **/
    public void setOption(String option) {
        this.option = option;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChoiceQuestionOption)) return false;
        ChoiceQuestionOption that = (ChoiceQuestionOption) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getSequence(), that.getSequence()) && Objects.equals(getOption(), that.getOption()) && Objects.equals(getChoiceQuestion(), that.getChoiceQuestion());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getSequence(), getOption(), getChoiceQuestion());
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ChoiceQuestionOption.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("sequence=" + sequence)
                .add("option='" + option + "'")
                .add("choiceQuestion=" + Identifiable.toString(choiceQuestion))
                .toString();
    }

}
