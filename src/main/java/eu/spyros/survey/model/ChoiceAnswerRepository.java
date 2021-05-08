package eu.spyros.survey.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created at 2021-05-08
 *
 * @author Spyros Koukas
 */
@RepositoryRestResource(collectionResourceRel = "choice_answers", path = "choice_answers")
public interface ChoiceAnswerRepository extends JpaRepository<ChoiceAnswer, Long> {

	ChoiceAnswer findById(long id);
}
