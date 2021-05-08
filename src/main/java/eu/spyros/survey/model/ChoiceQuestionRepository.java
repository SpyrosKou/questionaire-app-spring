package eu.spyros.survey.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created at 2021-05-08
 *
 * @author Spyros Koukas
 */
@RepositoryRestResource(collectionResourceRel = "choice_questions", path = "choice_questions")
public interface ChoiceQuestionRepository extends JpaRepository<ChoiceQuestion, Long> {

	ChoiceQuestion findById(long id);
}
