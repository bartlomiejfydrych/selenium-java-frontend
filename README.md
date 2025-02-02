<div align="center">
  <img src="project_banner.png" alt="project banner, selenium and java logo, project name">
</div>

# 🚧Repository under construction - do not enter🚧

# 📑Information about this repository (for recruiters)

## 📄Description

### Introduction

Hello to all recruiters and I invite you to check out my repository.🙋‍♂️

This repository was created so that I could easily organize and better absorb all the knowledge acquired during
**the test automation course conducted by "Sii Poland"**.

A separate repository will be allocated for **API testing using REST Assured.**

### About repository

This repository contains **Frontend Tests using Selenium and Java.**

I covered **two websites** with tests containing **different elements and mechanisms**.

I have described everything I have learned in the lower sections of this document.

*Why didn't I cover a "normal" website, e.g. an online store?*  
Because most of the steps on such a website are very simple and repeatable, so I wouldn't really learn much there.  
I'm saving such websites for learning how to write tests using BDD in the distant future.

### Additional notes

Some of the comments in the repository are in Polish, so that when I come back to it, I can more easily remember and
understand what a given piece of code was about.

There are also comments in English to explain to you (recruiters) what a given piece of code is about and why I wrote
a given method/test this way and not another.

## 🏆Certificates - test automation course (Sii Poland)

In the catalogue:  
&emsp;📁documents  
&emsp;&emsp;📁certificates

I have placed here certificates of completion of the test automation course conducted by "Sii Poland".

This course consisted of 3 parts:

- **Part 1:** Basics of programming in `Java`
- **Part 2:** Writing frontend tests in `Selenium`
- **Part 3:** Writing API tests in `REST Assured`

## 🧰Used frameworks and technologies

### General

- IntelliJ IDEA
- Java
- Dotenv Java
- ChatGPT (for refactor and complicated methods)

### Frontend (tests)

- Selenium
- Selenium Support
- WebDriver Manager

### Tests

- JUnit
- JUnit Platform Suite
- Java Faker
- AssertJ
- Allure Report

## 🌐Pages covered with tests

### Links

- [Tools QA](https://demoqa.com/)
- [Testerczaki](https://dawidkaruga.pl/testerczaki/)

### Description

**Tools QA** – A website for practicing interacting with various website elements, e.g. forms, alerts, checkboxes and
many others.

**Testerczaki** – Like "Tools QA" a website for practicing interacting with various website elements BUT the exercises
are done better. However, "QA Test" has exercises that "Testerczaki" do not have.

## 🎯What I learned and what I practiced

### General

#### Project

- Project setup (JDK etc.)
- Setting `.gitignore` file for Java files and more
- Adding dependencies from Maven repository to `pom.xml` file
- Setting variables to dependency versions in Maven
- Finding out what each framework/dependencies is responsible for
- Generating the project structure in the console using the `tree` command
- Refactor and optimize code with `ChatGPT`
- Installing and using plugins for IDE:
  - .ignore
  - Rainbow Brackets
  - Key Promoter X
  - Allure Report

#### Java

- Using environment variables (`.env`) with Dotenv Java
- Using `Builder`
- Using `config.properties` file
- Using `Enum` variables
- Managing file paths with `Paths.get()` methods
- Directory and class naming convention

#### Tests

- Using the `Page Object Pattern`
- Configuring `Allure Report` and generating a test report
- Generating random test data with `JavaFaker`
- Using the `Arrange-Act-Assert` pattern
- Setting tests to run in a specific order with `JUnit Suite`
- Checking the `CSS Attribute` of a Web Element
- Using assertions from the `AssertJ` framework

### Tools QA

#### Elements

- Text Box:
  - Filling out a simple form
  - Getting and checking the expected text
  - Concatenating Strings
- Check Box:
  - Expanding and collapsing lists
  - Checking and unchecking checkboxes
- Radio Button:
  - Checking radiobuttons
- Web Tables:
  - Adding, editing, searching and reading data from table rows
  - Waiting for a Web Element to load
- Buttons:
  - Clicking buttons with single, double and right clicks
- Links:
  - Clicking links
  - Waiting for a new tab to load
  - Switching between tabs
- Broken Links - Images:
  - Checking for unloaded images and broken links
  - Checking image dimensions
  - Checking the current page address
  - Getting HTTP status
- Upload and Download:
  - Downloading files
  - Uploading files
  - Waiting for a file to download
  - Deleting a downloaded file
- Dynamic Properties:
  - Getting and checking the random ID of the element
  - Waiting for the button to be clickable
  - Getting and checking the color of the button/element
  - Waiting for the button/element to change color
  - Waiting for the button/element to be visible

#### Forms

- Practice Form
  - Filling and validating data in a larger form containing many different types of Web Elements
  - String Formatting

#### Alerts, Frame & Windows

- Browser Windows:
  - Waiting for a new tab/window to load
  - Opening and switching between tabs/windows
  - Enlarging the window to full screen
- Alerts:
  - Opening alerts
  - Waiting for alerts
  - Getting alert text
  - Typing text into the alert
  - Accepting the alert
  - Closing the alert
- Frames:
  - Switching between iFrames
  - Getting text from an iFrame
  - Getting the page source from an iFrame
- Nested Frames:
  - Switching between nested iFrames
  - Getting text from nested iFrames
  - Getting the page source from nested iFrames
- Modal Dialogs:
  - Opening modal windows
  - Waiting for the modal window slide animation to finish
  - Getting text from modal windows
  - Closing modal windows

#### Widgets

- Accordian: (on the website they wrote it with a typo)
  - Waiting for the element to be visible/invisible
  - Fetching and comparing text
- Auto Complete:
  - Approving elements that appear as hints in inputs
- Date Picker:
  - Selecting a date in the date picker
  - Selecting a date and time in the date picker
  - Modifying the date and time format
  - Generating a random date and time in the selected range
- Slider:
  - Moving the slider using JavaScript
  - Moving the slider along the X axis
  - Moving the slider by pressing the arrow keys on the keyboard
- Progress Bar:
  - Waiting for the entire progress bar to load
  - Waiting and stopping the progress bar loading until it reaches a specified value
- Tabs:
  - Clicking on tabs on the page
  - Waiting for the text from the tab to load
- Tool Tips:
  - Hovering over an element
  - Waiting for the tool tip to appear
  - Fetching text from the tool tip
- Menu:
  - Moving the cursor through the menu items
- Select Menu:
  - Using a select that contains groups
  - Using a select that selects only one item
  - Using a simple old-style select
  - Using a multiselect drop down
  - Using a standard multiselect where we can see all the items at once, and we only need to select them

#### Interactions

- Sortable:
  - Sorting a list of items by moving them
  - Sorting tiles-items by moving them
- Selectable:
  - Selecting items in a list
  - Selecting tiles-items
  - Checking if items are selected
- Resizable:
  - Changing the size of windows/frames/inputs on the page
- Droppable:
  - Moving and dropping an item onto another item
  - Moving and dropping an item onto another item and checking if it has been accepted
  - Moving and dropping an item onto another item and checking if it has not been accepted
  - Moving and dropping an item onto two nested other items and checking if both have accepted it
  - Moving and dropping an item onto two nested other items and checking if only the inner item has accepted it
  - Moving and dropping an item onto another item and checking if it has returned to its previous position
  - Moving and dropping an item onto another item and checking if it has not returned to its previous position place
- Dragabble: (on the website they wrote it with a typo)
  - Moving elements along the X and Y axes
  - Moving an element inside a box
  - Moving text itself inside a box
  - Moving an element that the cursor grabs in the middle
  - Moving an element that the cursor grabs in the top left corner
  - Moving an element that the cursor grabs at the bottom
  - Checking the "left" and "top" positions of a moved element

#### Book Store Application

SOON

### Testerczaki

SOON

### Solved problems

- Deleting directories from previous IDE versions in the AppData folder that were cluttering up the system drive
- Removing page elements (ads) using JavaScript that blocked access to other elements and increased test instability
- Creating dynamic locators (when we need to insert a variable with text under the locator)
- Accessing a private WebElement in an assertion using `Getter`
- Writing a method that checks if an element is not visible without returning an error that it was not found
- Clicking a button that is inside another element using `actions`
- Writing a method that checks if an element is clickable without returning an error
- Using `ExpectedConditions` instead of `Thread.sleep()` to wait until an element contains a specific text
- Waiting for an element that changes very quickly and frequently using `pollingEvery()`
- Checking for a broken link or image using `HttpURLConnection`
- Getting image dimensions using JavaScript
- Disabling the display of the default search engine in Chrome using `options.addArguments("--disable-search-engine-choice-screen");`
- Keeping the expanded select using DevTools
- Keeping hover/tool tip visible using DevTools
- Fixing bugs after upgrading dependencies in Maven by turn off and on the IDE
- Writing a method that checks if an element has finished animating its movement
- Getting to know CDP bug after updating DevTools in Selenium
- Fixing `SLF4J` warnings

## 🤡How can Frontend developer make Tester mad?

By adding on website **a lot of**:
- Tables
- Calendars (date pickers)
- Unusual windows with about:blank URL
- Nested iFrames
- Sliders
