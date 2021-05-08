package eu.spyros.survey.model;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 *
 */
@Entity
public class CustomerRideFeedback implements Identifiable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //Using double so partial star ratings are available.
    private Double starRating;

    @Column(name = "timestamp", columnDefinition = "TIMESTAMP")
    private LocalDateTime timestamp;

    @OneToOne
    @JoinColumn(name = "ride_feedback_request_id", referencedColumnName = "id")
    private RideFeedbackRequest rideFeedbackRequest;

    protected CustomerRideFeedback() {
    }


    public Long getId() {
        return id;
    }


}
