package eu.spyros.questionnaire.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccessingDataRestApplication {
    private static final Logger log = LoggerFactory.getLogger(AccessingDataRestApplication.class);

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private RideRepository rideRepository;

    public static void main(String[] args) {
        SpringApplication.run(AccessingDataRestApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner demo() {
//        return (args) -> {
//            // save a few customers
//            final Customer jackBauer = customerRepository.save(new Customer("Jack", "Bauer"));
//            final Customer chloeOBrian = customerRepository.save(new Customer("Chloe", "O'Brian"));
//            final Customer kimBauer = customerRepository.save(new Customer("Kim", "Bauer"));
//            final Customer davidPalmer = customerRepository.save(new Customer("David", "Palmer"));
//            final Customer micheleDessler = customerRepository.save(new Customer("Michelle", "Dessler"));
//
//            final Ride jacksRide = rideRepository.save(new Ride(jackBauer));
//
//
//            // fetch all customers
//            log.info("Customers found with findAll():");
//            log.info("-------------------------------");
//            for (final Customer customer : customerRepository.findAll()) {
//                log.info(customer.toString());
//            }
//            log.info("--------------------------------");
//            for (final Ride ride : rideRepository.findAll()) {
//                if (ride != null) {
//                    log.info(ride.toString());
//                }
//            }
//            // fetch an individual customer by ID
//            Customer customer = customerRepository.findById(1L);
//            log.info("Customer found with findById(1L):");
//            log.info("--------------------------------");
//            log.info(customer.toString());
//            log.info("");
//
//            // fetch customers by last name
//            log.info("Customer found with findByLastName('Bauer'):");
//            log.info("--------------------------------------------");
//            customerRepository.findByLastName("Bauer").forEach(bauer -> {
//                log.info(bauer.toString());
//            });
//            // for (Customer bauer : customerRepository.findByLastName("Bauer")) {
//            // 	log.info(bauer.toString());
//            // }
//            log.info("");
//        };
//    }
}
