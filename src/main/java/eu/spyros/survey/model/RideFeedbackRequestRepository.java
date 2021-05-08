package eu.spyros.survey.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created at 2021-05-08
 *
 * @author Spyros Koukas
 */
@RepositoryRestResource(collectionResourceRel = "ride_feedback_requests", path = "ride_feedback_requests")
public interface RideFeedbackRequestRepository extends JpaRepository<CustomerRideFeedbackRequest, Long> {

    CustomerRideFeedbackRequest findById(long id);
}
