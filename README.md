**Project Name: E-commerce Website with Selenium and TestNG**

---

Welcome to the E-commerce Website project! This README provides an overview of the project structure, its pages, and the included test files, which utilize Selenium and TestNG for automated testing.

### Project Structure

The project consists of the following structure:

1. **Pages**:
   - **Home Page**: The landing page of the website, containing featured products and navigation links.
   - **Product Page**: Displays detailed information about a specific product, such as images, descriptions, and pricing.
   - **Checkout Page**: Allows users to review their selected items, input shipping and payment information, and complete the purchase.
   - **Sign-in Page**: Provides fields for users to sign in with their credentials.

2. **Tests**:
   - **Complete Purchase Test**: Verifies that an unregistered user can search for an item, add it to the cart, and complete the purchase process.
   - **Registration Tests**: Ensures that users can create new accounts on the website.
   - **Sign-in Tests**: Validates that users can log in with existing account credentials.

### Automated Testing with Selenium and TestNG

The tests utilize Selenium, a popular automation tool, to interact with the web pages, and TestNG, a testing framework, to organize and execute the test cases.

### Running the Tests

To run the tests, follow these steps:

1. Ensure that the necessary dependencies, including Selenium and TestNG, are installed in your project environment.

2. Navigate to the directory containing the test files.

3. You can run the tests in your preferred IDE or from the command line. To run tests using TestNG XML files, follow these steps:

   - **Individual Test XML Files**: Use the following XML files to run each test individually:
     - `complete_purchase.xml`
     - `registration.xml`
     - `sign_in.xml`
   
   - **All Tests XML File**: To run all tests, use the following XML file:
     - `all_tests.xml`


---