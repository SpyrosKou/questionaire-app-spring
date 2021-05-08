package eu.spyros.questionnaire.domain;

import org.springframework.data.repository.CrudRepository;


public interface RideRepository extends CrudRepository<Ride, Long> {

	Ride findById(long id);
}
