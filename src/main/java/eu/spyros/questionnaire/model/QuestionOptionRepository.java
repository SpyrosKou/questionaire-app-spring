package eu.spyros.questionnaire.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created at 2021-05-08
 *
 * @author Spyros Koukas
 */
@RepositoryRestResource(collectionResourceRel = "questions_options", path = "questions_options")
public interface QuestionOptionRepository extends JpaRepository<QuestionOption, Long> {

    QuestionOption findById(long id);
}
