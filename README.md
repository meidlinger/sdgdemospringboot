add user: curl localhost:8080/v1/api/sdg/demo/person -d name=Darren -d title="Partner"
list all user: curl localhost:8080/v1/api/sdg/demo/person/all
check title:  curl localhost:8080/v1/api/sdg/demo/person/title?name=Darren