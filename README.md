# About the project:
JumiaPhoneValidator is a microservice for listing, validating and categorizing country phone numbers by country, state (valid or not valid), country 
                                                                  code and number. 
# Used Technologies: 
- **Spring-Boot:** For exposing APIs and modifying the DB 
- **Angular 9:** For Web view
- **H2** For in memory DB so it be easy to run the project 

# ERD: 
![Alt text](ERD.jpg?raw=true "ERD")

# Exposed APIs: 
- **Path:** /Lookups/countries ,

    - **Method:** Get 

    - **Description:** this method is responsible for getting only list of countries names and ids for filtering

- **Path:** /country-phone-number

     - **Method:** Post 
 
     - **Description:** this method is responsible for getting list of country phone numbers
     
     - **body:** ``` {
                         "vaccinationDay": "2020-12-08",
                         "pageSize": "10",
                         "pageNumber": "0",
                         "countryFilter": "Cameroon", // do not sent if no need for filtering
                         "statusFilter":"true" // do not sent if no need for filtering
                     }``` 


# Web View:

![Alt text](webViewScreenShoots1.png?raw=true "1")
![Alt text](webViewScreenShoots2.png?raw=true "2")
![Alt text](webViewScreenShoots3.png?raw=true "3")


# Putting Project on rails:
For running the project
- download the repo
- run the command  : **docker-compose up --build --force-recreate**

