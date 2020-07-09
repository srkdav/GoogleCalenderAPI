
<!-- PROJECT SHIELDS -->
<!-- PROJECT LOGO -->
<br />
<p align="center">
 
  <h3 align="center">Google Calender REST API</h3>

  <p align="center">
   The REST API enables you to view and add events for a particular User.
    <br />
  </p>
</p>

### Built With
   * Spring Boot 
   * MySql

### BackGround  
           
 There is a one to many relationship between User and Event. 
 Each User can have multiple Events. Event has a field User ID as the foreign key.

### Commands to run  
            
1) Clone the repository to a "Projects" folder.
2) Open the project "GoogleCalenderAPI" in STS 3/4/ Eclipse preferably.
3) Please ensure all the dependencies are available as per pom.xml.
4) Modify the application.properties file as per MySQL properties of your system adn create a Database of the same name too.
 - spring.datasource.url=jdbc:mysql://localhost:3306/googleapi -> here "googleapi" is the DB that i have created before deploying the project.
 - Ensure password and username are as per the MySQL properties.
   > run the command SELECT * FROM mysql.user; to find them out.
5) Update the maven project in case there is some abnormality like main class not found etc
6) Run the project as "Spring boot app"

### Process to use the REST API
1) Ensure a user is registered before going ahead.
 - POST request at http://localhost:8080/user/SetUser & send JSON data as : 
 > {
 >   "name" : "xyz"
 >   "email" :"xyz@gmail.com"
 > }
  - Ideally the id would be "1". Please ensure the id if multiple users are added.
 
 2) Ensure events are sent as list, even if its just one event : 
  - POST request at http://localhost:8080/event/AddEvent & send JSON data as :
    >
    > [
    >  {
    >      "name": "meeting",
    >      "date": "2020-10-10",
    >      "start": "01:01:01",
    >      "end": "02:01:01",
    >      "user_id": 1
    >  },
    >  {
    >      "name": "discussion",
    >      "date": "2020-10-10",
    >      "start": "03:01:01",
    >      "end": "04:00:00",
    >      "user_id": 1
    >  }
    >]
  
  3) Get the list of all events
   - GET request at http://localhost:8080/event/GetEventsByUser/1
   - Here /1 is the User ID.


                 
                  
