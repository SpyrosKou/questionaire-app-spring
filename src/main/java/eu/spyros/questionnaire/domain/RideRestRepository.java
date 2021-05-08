package eu.spyros.questionnaire.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "rides", path = "rides")
public interface RideRestRepository extends PagingAndSortingRepository<Ride, Long> {

	Ride findById(long id);
}
