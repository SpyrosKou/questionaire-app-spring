package eu.spyros.survey.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccessingDataRestApplication {
    private static final Logger log = LoggerFactory.getLogger(AccessingDataRestApplication.class);


    public static void main(String[] args) {
        SpringApplication.run(AccessingDataRestApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(
            final CustomerRepository customerRepository,
            final RideRepository rideRepository,
            final RideSurveyRepository rideSurveyRepository,
            final RideFeedbackRequestRepository rideFeedbackRequestRepository) {
        return (args) -> {
            // save a few customers
            final Customer jackBauer = customerRepository.save(new Customer("Jack", "Bauer"));
            final Customer chloeOBrian = customerRepository.save(new Customer("Chloe", "O'Brian"));
            final Customer kimBauer = customerRepository.save(new Customer("Kim", "Bauer"));
            final Customer davidPalmer = customerRepository.save(new Customer("David", "Palmer"));
            final Customer micheleDessler = customerRepository.save(new Customer("Michelle", "Dessler"));

            final RideSurvey satisfactionSurvey = rideSurveyRepository.save(new RideSurvey());

            final Ride jacksRide = rideRepository.save(new Ride(jackBauer));

            final CustomerRideFeedbackRequest rideFeedbackRequest = rideFeedbackRequestRepository.save(new CustomerRideFeedbackRequest(jacksRide, satisfactionSurvey));

            final FreeTextQuestion freeTextQuestion = new FreeTextQuestion();


        };
    }
}
