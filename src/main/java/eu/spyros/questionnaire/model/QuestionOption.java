package eu.spyros.questionnaire.model;

import javax.persistence.*;

/**
 * Created at 2021-05-08
 *
 * @author Spyros Koukas
 */
@Entity
@Table(name = "question_option")
public class QuestionOption {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * The sequence of appearance
     */
    private Integer sequence;
    /**
     * Option textual description
     */
    private String option;
    @ManyToOne
    @JoinColumn(name = "choice_question_id", referencedColumnName = "id")
    private ChoiceQuestion choiceQuestion;
}
