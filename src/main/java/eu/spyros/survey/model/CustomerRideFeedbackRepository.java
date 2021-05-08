package eu.spyros.survey.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created at 2021-05-08
 *
 * @author Spyros Koukas
 */
@RepositoryRestResource(collectionResourceRel = "customer_ride_feedbacks", path = "customer_ride_feedbacks")
public interface CustomerRideFeedbackRepository extends JpaRepository<CustomerRideFeedbackResponse, Long> {

	CustomerRideFeedbackResponse findById(long id);
}
