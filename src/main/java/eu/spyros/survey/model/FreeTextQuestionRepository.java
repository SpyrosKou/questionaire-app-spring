package eu.spyros.survey.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created at 2021-05-08
 *
 * @author Spyros Koukas
 */
@RepositoryRestResource(collectionResourceRel = "free_text_questions", path = "free_text_questions")
public interface FreeTextQuestionRepository extends JpaRepository<FreeTextQuestion, Long> {

	FreeTextQuestion findById(long id);
}
