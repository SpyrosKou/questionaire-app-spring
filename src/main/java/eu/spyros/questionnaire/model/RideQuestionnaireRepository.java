package eu.spyros.questionnaire.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created at 2021-05-08
 *
 * @author Spyros Koukas
 */
@RepositoryRestResource(collectionResourceRel = "ride_questionnaires", path = "ride_questionnaires")
public interface RideQuestionnaireRepository extends JpaRepository<RideQuestionnaire, Long> {

	RideQuestionnaire findById(long id);
}
