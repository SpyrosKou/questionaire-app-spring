package eu.spyros.questionnaire.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created at 2021-05-08
 *
 * @author Spyros Koukas
 */
@Entity
@Table(name = "choice_question")
public class ChoiceQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String question;

    /**
     * Allows the user to specify how many options will be selected. For allowedSelections==1
     */
    private Integer allowedSelections;

    @ManyToOne
    @JoinColumn(name = "ride_questionnaire_id", referencedColumnName = "id")
    private RideQuestionnaire rideQuestionnaire;

    @OneToMany(mappedBy = "choiceQuestion")
    private List<QuestionOption> questionOptions;

    protected ChoiceQuestion() {
    }


}
