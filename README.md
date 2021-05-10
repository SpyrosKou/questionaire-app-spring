# [Questionaire-app-spring](https://github.com/SpyrosKou/questionaire-app-spring)
A simple questionnaire experimentation app using [Spring Data JPA](https://spring.io/projects/spring-data-jpa), [Spring Data REST](https://spring.io/projects/spring-data-rest) and [React.js](https://reactjs.org)

## Design
- Uses an in memory [H2 database](http://www.h2database.com/html/main.html) for brevity. 
- Entity Relationship Diagram
  
<img src="https://raw.githubusercontent.com/SpyrosKou/questionaire-app-spring/main/questionaire-app-spring.svg">


- 
- All data are persisted in memory, not permanently stored.
- If a survey needs to be filled for a ride, the [CustomerRideFeedbackRequest](https://github.com/SpyrosKou/questionaire-app-spring/blob/main/src/main/java/eu/spyros/survey/model/CustomerRideFeedbackRequest.java) should include a [RideSurvey](https://github.com/SpyrosKou/questionaire-app-spring/blob/main/src/main/java/eu/spyros/survey/model/RideSurvey.java)
- A [RideSurvey](https://github.com/SpyrosKou/questionaire-app-spring/blob/main/src/main/java/eu/spyros/survey/model/RideSurvey.java)  can be reused or a different [RideSurvey](https://github.com/SpyrosKou/questionaire-app-spring/blob/main/src/main/java/eu/spyros/survey/model/RideSurvey.java)  can be created and used when needed.

## Requirements
Java Version 11 or newer is required.

## Instructions
Data can be viewed, in a raw json hal format, from [the rides](http://127.0.0.1:8080/rides) after the application is started.
### Windows
Start the application by running `gradlew.bat bootRun`.

### Linux
Run `./gradlew bootRun`. 