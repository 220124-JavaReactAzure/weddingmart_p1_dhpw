# WeddingMart

The WeddingMart API supports the creation of a multi-purpose User account. Once created, a User can become an Employee, an Attendee, or Betrothed.

An Employee can be marked as a manager, and this could be used to control extra privileges for Employee accounts.

An Attendee is linked to a Wedding, can be marked with an rsvp and a plus one rsvp. A MealOrder and MealOrderPlusOne can link an Attendee and their potential plus one with a MealChoice.

A Betrothed is linked to a Wedding, which tracks their budget, wedding date, and the date by which they need their Attendees to rsvp.

Thanks to the way the database is structured a User can be an Employee, a Betrothed on their own wedding, and an Attendee on multiple weddings. Any number of Users can be Betrothed on a wedding, so although WeddingMart has no political position on polyamory the software does support it!

Weddings can be linked to Assets using an AssetBooking, which allows a Wedding to book multiple instances of an asset type if so desired, such as multiple photographers or musicians.

## Rest Endpoints and supported Verbs:

http://hostname/WeddingMart

- /user POST GET PUT
- /user/id GET DELETE
- /employee POST GET PUT
- /employee/id GET DELETE
- /betrothed POST GET PUT
- /betrothed/id GET DELETE
- /wedding POST GET PUT
- /wedding/id GET DELETE
- /assetType GET
- /asset POST GET PUT DELETE
- /asset/id GET DELETE
- /assetBooking POST GET PUT
- /assetBooking/id GET DELETE
- /attendee POST GET PUT
- /attendee/id GET DELETE
- /mealChoice GET
- /mealOrder POST GET PUT
- /mealOrder/id GET DELETE
- /mealOrderPlusOne POST GET PUT
- /mealOrderPlusOne/id GET DELETE

## Tech Stack

-   [ ] Java 8
-   [ ] JUnit 4.13.2
-   [ ] Mockito 4.3.1
-   [ ] Apache Maven 4.0.0
-   [ ] Hibernate 5.4.32.Final
-   [ ] java.util.logging 8
-   [ ] Jackson 2.13.1
-   [ ] React 17.0.2
-   [ ] Java EE Servlet API (v4.0+)
-   [ ] Azure SQL 7.4.1.jre8
-   [ ] Git SCM (on GitHub)
-   [ ] Trello

## Entity Relationship Diagram

![Entity Relationship Diagram](erd.png?raw=true "Entity Relationship Diagram") 

The REST server can be deployed using maven with goal tomcat7:deploy.

The front end is still in development mode, to run it, go the the frontend directory and execute the 'npm start' command. CORs must be disabled at the browser level or the frontend requests will be rejected.

WeddingMart features a complete REST API that can create and manage all the data relationships necessary to plan a wedding.

Contributors: Philip Wentworth (guitartheist) and Darrell Hamilton (dhami1012).

Future goals: Implement user authentication, services check that logged in User has authorization to perform the action before the service performs that action, frontend served so that CORs does not need to be disabled, fully functional front end that consumes and REST endpoints and also enforces the business logic on the UI side so no bad requests are sent to the API.
