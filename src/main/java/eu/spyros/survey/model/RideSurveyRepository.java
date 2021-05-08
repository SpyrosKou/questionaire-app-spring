package eu.spyros.survey.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created at 2021-05-08
 *
 * @author Spyros Koukas
 */
@RepositoryRestResource(collectionResourceRel = "ride_surveys", path = "ride_surveys")
public interface RideSurveyRepository extends JpaRepository<RideSurvey, Long> {

	RideSurvey findById(long id);
}
