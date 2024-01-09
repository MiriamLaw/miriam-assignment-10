Spoonacular Meal Planner

Description:
This Spring Boot application integrates with the Spoonacular API to generate meal plans based on daily or weekly preferences. Users can specify 
the number of calories, diet type, and food exclusions to get tailored meal plans.

Technologies Used:
Java 11
Spring Boot
Maven
Spring Web MVC
RESTful Web Services
JUnit and Mockito for testing
API Registration

Clone the repository: git clone [https://github.com/MiriamLaw/miriam-assignment-10.git].
Import the project into your IDE as a Maven project.
Run the application from the main class MiriamAssignment10Application.java.
Usage

The application provides two main endpoints:

/mealplanner/day: To generate a daily meal plan.
/mealplanner/week: To generate a weekly meal plan.
Both endpoints accept the following parameters:

numCalories: Target number of calories (e.g., 2000).
diet: Type of diet (e.g., vegetarian).
exclusions: Food items to exclude (e.g., nuts).
Example request: http://localhost:8080/mealplanner/day?numCalories=2000&diet=vegan&exclusions=meat

Testing:
Run unit tests directly from the IDE.
Use the provided Postman collection located in the postman directory of this repository for API testing. Import the collection 
into Postman and test the endpoints.

Contributing:
Contributions to this project are welcome. Please fork the repository and submit a pull request with your changes.

Contact/Support:
For any questions or support, please contact [Miriam Law] at [miriam.p.law@gmail.com].
