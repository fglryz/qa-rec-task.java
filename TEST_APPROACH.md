## Scenario
There is an API which returns based on a date whether it is a working day for the carer or not.   
For Example The Carer works Monday to Friday. So, a date which falls on a Saturday
would return that it is not a working day.
## Task 1
We are going to push this API to production for the first time. In order to ensure
we have delivered quality, reliable and stable software what approach should we take?
1. Add a TEST-APPROACH.md explaining your test approach for this task, including different levels & types of test

MY APPROACH
The first step in ensuring delivered high-quality, reliable and stable software is to make
manual API testing with Postman
If there is a swagger document, I practice with Swagger Documents to understand which endpoints are available, which variables I can utilise
I practice manual API testing from Dev Tool(Network) and Postman if there are no documents.

I use the GET method with the correct endpoints to retrieve information from the given URL.
1. I go to my workspace in Postman.
2.  I set my HTTP request to GET with "https://ceracare.co.uk/carer?date=2021-11-07"
3. I clicked on the Send button.
4. I accepted 200 OK Message
5. There should be results in the body which indicate that my test has run successfully


I also do negative Tests (I write the date that does not match weekends) ,
Edge cases Test (date:25-15-40, 56N-12B-C07)

## Task 2
Using [SpringBoot](https://spring.io/guides/gs/testing-web/) complete the tasks below.
1. Fix the failing test / Done
2. Add a test for a negative scenario / Done
3. Refactor anything you would improve / When I sent the dates that are workdays and weekends,
   I accepted the 200 status code, so I decided that something is wrong with the java code.
   I went to CarerController java class, and  I add default  workingdays= false  to CarerController class to see 
   if the given date is not inside the working days(Monday", "Tuesday", "Wednesday", "Thursday", "Friday")

