package eu.spyros.survey.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created at 2021-05-08
 *
 * @author Spyros Koukas
 */
@RepositoryRestResource(collectionResourceRel = "choice_question_options", path = "choice_question_options")
public interface ChoiceQuestionOptionRepository extends JpaRepository<ChoiceQuestionOption, Long> {

	ChoiceQuestionOption findById(long id);
}
