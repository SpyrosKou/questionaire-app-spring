package eu.spyros.questionnaire.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class CustomerRideFeedback {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //Using double so partial star ratings are available.
    private Double starRating;

    @Column(name = "timestamp", columnDefinition = "TIMESTAMP")
    private LocalDateTime timestamp;

    protected CustomerRideFeedback() {
    }


    public Long getId() {
        return id;
    }


}
