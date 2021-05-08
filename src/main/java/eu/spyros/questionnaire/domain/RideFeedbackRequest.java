package eu.spyros.questionnaire.domain;

import javax.persistence.*;

@Entity
@Table(name="ride_feedback_request")
public class RideFeedbackRequest {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	protected RideFeedbackRequest() {}

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ride_id")
	private Ride ride;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ride_questionnaire_id")
	private RideQuestionnaire rideQuestionnaire;
}
