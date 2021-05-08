package eu.spyros.questionnaire.model;

import javax.persistence.*;

/**
 * Created at 2021-05-08
 *
 * @author Spyros Koukas
 */
@Entity
@Table(name = "free_text_question")
public class FreeTextQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String question;
    @ManyToOne
    @JoinColumn(name = "ride_questionnaire_id", referencedColumnName = "id")
    private RideQuestionnaire rideQuestionnaire;

    protected FreeTextQuestion() {
    }

    public FreeTextQuestion(String question, RideQuestionnaire rideQuestionnaire) {
        this.question = question;
        this.rideQuestionnaire = rideQuestionnaire;
    }

    public FreeTextQuestion(String question) {
        this.question = question;
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
     * Getter for rideQuestionnaire
     *
     * @return rideQuestionnaire
     **/
    public RideQuestionnaire getRideQuestionnaire() {
        return rideQuestionnaire;
    }

    /**
     * Setter for rideQuestionnaire
     *
     * @param rideQuestionnaire
     **/
    public void setRideQuestionnaire(RideQuestionnaire rideQuestionnaire) {
        this.rideQuestionnaire = rideQuestionnaire;
    }
}
