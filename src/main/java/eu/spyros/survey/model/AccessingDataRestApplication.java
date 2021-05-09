package eu.spyros.survey.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AccessingDataRestApplication {
    private static final Logger log = LoggerFactory.getLogger(AccessingDataRestApplication.class);


    public static void main(String[] args) {
        SpringApplication.run(AccessingDataRestApplication.class, args);
    }


    @Bean
    public CommandLineRunner demo(CustomerRepository customerRepository,

                                  RideRepository rideRepository,

                                  RideSurveyRepository rideSurveyRepository,
                                  RideSurveyResponseRepository rideSurveyResponseRepository,

                                  CustomerRideFeedbackRequestRepository customerRideFeedbackRequestRepository,
                                  CustomerRideFeedbackResponseRepository customerRideFeedbackResponseRepository,

                                  FreeTextQuestionRepository freeTextQuestionRepository,
                                  FreeTextAnswerRepository freeTextAnswerRepository,

                                  ChoiceQuestionRepository choiceQuestionRepository,
                                  ChoiceAnswerRepository choiceAnswerRepository,
                                  ChoiceQuestionOptionRepository choiceQuestionOptionRepository
    ) {
        return (args) -> {
            // save a few customers
            final Customer jackBauer = customerRepository.save(new Customer("Jack", "Bauer"));
            final Customer chloeOBrian = customerRepository.save(new Customer("Chloe", "O'Brian"));
            final Customer kimBauer = customerRepository.save(new Customer("Kim", "Bauer"));
            final Customer davidPalmer = customerRepository.save(new Customer("David", "Palmer"));
            final Customer micheleDessler = customerRepository.save(new Customer("Michelle", "Dessler"));


            //Create a survey
            final RideSurvey satisfactionSurvey = rideSurveyRepository.save(new RideSurvey());

            final FreeTextQuestion freeTextQuestion = freeTextQuestionRepository.save(new FreeTextQuestion("What did you enjoy in the ride?", satisfactionSurvey));

            final ChoiceQuestion multipleChoiceQuestion = choiceQuestionRepository.save(ChoiceQuestion.createMultipleChoice("What did you appreciate?", 3, satisfactionSurvey, List.of("Vehicle", "Music", "Safety")));
            multipleChoiceQuestion.getChoiceQuestionOptions().stream().forEach(choiceQuestionOptionRepository::save);

            final ChoiceQuestion singleChoiceQuestion = choiceQuestionRepository.save(ChoiceQuestion.createSingleChoice("Would you ride again?", satisfactionSurvey, List.of("Yes", "No")));
            singleChoiceQuestion.getChoiceQuestionOptions().stream().forEach(choiceQuestionOptionRepository::save);


            final Ride jacksRide = rideRepository.save(new Ride(jackBauer));

            //Lets assume that the system requests for a survey
            final CustomerRideFeedbackRequest customerRideFeedbackRequest = customerRideFeedbackRequestRepository.save(new CustomerRideFeedbackRequest(jacksRide, satisfactionSurvey));

            //first part of the CustomerRideFeedbackResponse
            final CustomerRideFeedbackResponse customerRideFeedbackResponse = customerRideFeedbackResponseRepository.save(new CustomerRideFeedbackResponse(5.0, customerRideFeedbackRequest));

            //First part of the RideSurveyResponse
            final RideSurveyResponse rideSurveyResponse = rideSurveyResponseRepository.save(new RideSurveyResponse(customerRideFeedbackResponse));

            //And the answers
            final FreeTextAnswer freeTextAnswer = freeTextAnswerRepository.save(new FreeTextAnswer("The lack of traffic", "", rideSurveyResponse, freeTextQuestion));
            final ChoiceAnswer multipleChoiceAnswer = choiceAnswerRepository.save(ChoiceAnswer.createMultipleChoiceAnswer("", multipleChoiceQuestion, rideSurveyResponse, multipleChoiceQuestion.getChoiceQuestionOptions()));

            final ChoiceAnswer singleChoiceAnswer = choiceAnswerRepository.save(ChoiceAnswer.createSingleChoiceAnswer("", multipleChoiceQuestion, rideSurveyResponse, singleChoiceQuestion.getChoiceQuestionOptions().stream().findFirst().get()));


        };
    }
}
