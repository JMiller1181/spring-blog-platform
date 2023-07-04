In order to properly test the API you cannot just use the browser. Although it is possible to get the list of posts in
the browser by simply going to the URL http://localhost:8080/posts/list once the application is up and running, most
testing will need to be done in the terminal. Below I have made a list of commands that can be used in the terminal to
take advantage of the CRUD functionality.

Create->Invoke-RestMethod -Uri 'http://localhost:8080/posts/create' -Method POST -Headers @{"Content-Type" = "application/json"} -Body '{"title":"New Title","content":"New Content","author":"New Author"}'
This will create a new post. You can change the values in the body section of the JSON file to whatever test you want.

Read->curl -UseBasicParsing  http://localhost:8080/posts/list
This one is a little different from the others, but I found it is less to type, and works the same. If you need to find
a specific post you can add an ID to the end of the URL. This command obviously lists the existing posts.

Update->Invoke-RestMethod -Uri 'http://localhost:8080/posts/update/{id}' -Method PUT -Headers @{"Content-Type" = "application/json"} -Body '{"title":"Updated Title","content":"Updated Content","author":"Updated Author"}'
This command will update an existing post. The id should be the id of whatever post you are trying to update. Note that
you will have to add values for all the keys in the JSON body, or it will update the new value to be NULL. Will not work
if no post with the entered id exists.

Delete->Invoke-WebRequest -Uri 'http://localhost:8080/posts/delete/{id}' -Method DELETE
This quite simply deletes the post with the corresponding id. This command will obviously not do anything if a post with
the entered id does not exist.