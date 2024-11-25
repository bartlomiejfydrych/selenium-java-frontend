# 📚Book Store Application – Test Documentation

## 📌Register and Login user – important details

### Test order

Due to the high instability of this test collection (depending on whether we have registered user data or not), I will
try to set the test order so that this collection is always executed last.

### Register User

Due to the reCaptcha mechanism, it is not possible to automate full, correct user registration using Selenium.  
We will have to create an account ourselves and create an **ENV** file with its data, which will not be uploaded
to GitHub.

**We must register new user on this site:**  
https://demoqa.com/register

### User data

After registration, in the project directory we have the 📁environment directory.  
We need to create an `.env` file in it and set our registered user's data in these variables:

```.env
# book_store_application
TQ_BSA_USERNAME=yourUsername
TQ_BSA_PASSWORD=yourPassword
```

### Login user

Once we have a registered user and saved his data to the `.env` file, we can start running the test.  
In the `LoginTest.java` file, the test called `shouldLogInCorrectly()` should now execute correctly.

## 🧰Test cases

### Register

- shouldCaptchaBlockUs
- shouldNotRegisterWithoutCaptcha
- shouldRequireAllFields
- shouldBackToLoginButtonWork

### Login

- shouldLogInCorrectly
- shouldMarkEmptyFieldsInRed
- shouldNotLogInNonExistentUser
