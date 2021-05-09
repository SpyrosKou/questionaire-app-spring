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
@Table(name = "free_text_question")
public class FreeTextQuestion implements Identifiable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String question;
    @ManyToOne
    @JoinColumn(name = "ride_survey_id", referencedColumnName = "id")
    private RideSurvey rideSurvey;

    protected FreeTextQuestion() {
    }

    public FreeTextQuestion(String question, RideSurvey rideSurvey) {
        this.question = question;
        this.rideSurvey = rideSurvey;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FreeTextQuestion)) return false;
        FreeTextQuestion that = (FreeTextQuestion) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getQuestion(), that.getQuestion()) && Objects.equals(getRideSurvey(), that.getRideSurvey());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getQuestion(), getRideSurvey());
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", FreeTextQuestion.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("question='" + question + "'")
                .add("rideSurvey=" + Identifiable.toString(rideSurvey))
                .toString();
    }
}
