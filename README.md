# account

1. create app buld and image of account-app using docker compose build.
2. create and run containers od account-app image and postgres image using docker compose up -d.
3. check if containers are up and running using docker ps command.
4. send POST request from postman http://localhost:8080/v1/api/account with json body - 
 {

    "accountNumber" : 323456,
    "accountName" : "Michael",
    "userEmail" : "michael@example.com",
    "balance" : 30000.00
 }
5. hit the GET request from Postman "http://localhost:8080/v1/api/accounts", we should see the data.
6. hit the GET request from Postman "http://localhost:8080/v1/api/account/323456", we should see the data.

Or

1. Run the jenkin pipeline http://localhost:8080/job/my-account-pipeline/.
2. check if containers are up and running using docker ps command.
3. send POST request from postman http://localhost:8080/v1/api/account with json body - 
 {

    "accountNumber" : 323456,
    "accountName" : "Michael",
    "userEmail" : "michael@example.com",
    "balance" : 30000.00
 }
4. hit the GET request from Postman "http://localhost:8080/v1/api/accounts", we should see the data.
5. hit the GET request from Postman "http://localhost:8080/v1/api/account/323456", we should see the data.