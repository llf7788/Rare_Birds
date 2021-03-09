##Project Report
### “Rare Birds  – To See, To Protect”

Tips: 
To execute my project, first you should change the username and password in application.properties files and set a database named rarebirds. And then you can use data.sql in my submitted files to import the data.
When login, you can use admin as both username and password to login as admin. Manager and user is like the same to see the different.
Only admin has the authentication to click admin management below the page to get into use role control.
 

Short summary of the project
This project aims to share rare birds pictures and description to call on people to protect birds. It has login and register interfaces and once users login in, they could leave their comments right below the bird’s pictures. And the manager role can manage the comments to avoid bad words. The admin can change user’s role between normal user and manager.

Summary of the Functionality Performed
•	Guest can view birds’ pictures and information, sign up an account.
•	Registered user can sign in, sign out and comment on the site.
•	Manager can manage users’ comments.
•	Admin can manage accounts’ role.

Technologies used
•	For backend, Spring MVC, Annotation, Hibernate, MySQL
•	For frontend, HTML, jQuery, JavaScript and Ajax for calling backend services.

User Roles and performed tasks for each role
Guest: can only browse the pictures but cannot give comments.
Registered User: can browse the pictures and give comments.
Manager: can browse the pictures, give comments and manage users’ comments.
Admin: can change users’ roles between Registered User and Manager in Admin management.
