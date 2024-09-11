# OpenCart Automation Testing Project
This project focuses on automating test cases for the OpenCart e-commerce platform using Selenium and TestNG.

#### Demo URL:
* https://demo.opencart.com

#### The main Frameworks included in the project:
* Selenium WebDriver: For browser automation.
* TestNG: For managing and executing test cases.
* Extent Reports: For detailed test reporting.


#### Project Design:
* Follows the Page Object Model (POM) design pattern for organizing the code and making it scalable.
* Data-Driven Testing approach: Allows running the same test with multiple sets of data.
* Contains a Utilities package in the src/main/java directory which includes various helper methods for the project (e.g., handling waits, taking screenshots).
* Tests include GUI layer automation, interacting with web elements like forms, buttons, and links in OpenCart.


#### Test Scenarios:
* Login Test: Verifies that a user can successfully log in with valid credentials.
* Register Test: Ensures that users can search for products using the search bar.
* Add to Cart Test: Checks if a user can add a product to the cart and verify its presence in the cart.

#### How to Run:
1-Clone this repository:
* git clone https://github.com/Alaa-Ragab-sayed/opencart-testing.git

2-Navigate to the project folder:
* cd opencart-testing

3-Run the tests:
* mvn test

#### Future Enhancements:
* Add REST API testing to cover service layer tests.
* Include more test cases for advanced user actions (e.g., checkout and payment).
