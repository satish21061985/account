# account

1. create jar file from latest code using mvn clean install.
2. create image of account-app using docker compose build.
3. create and run containers od account-app image and postgres image using docker compose run -d.
4. check if containers are up and running using docker ps command.
5. send POST request from postman http://localhost:8080/v1/api/account with json body - 
 {

    "accountNumber" : 323456,
    "accountName" : "Michael",
    "userEmail" : "michael@example.com",
    "balance" : 30000.00
 }
6. hit the GET request from Postman "http://localhost:8080/v1/api/accounts", we should see the data.
7. hit the GET request from Postman "http://localhost:8080/v1/api/account/323456", we should see the data.