# DB start

- docker-compose up -d

# Example request (auth)
- http://localhost:8080/persons/by-city?city=Moscow
- http://localhost:8080/persons/by-age?age=52

# Example request (not auth)
- http://localhost:8080/persons/by-name?name=Sergej&surname=Ginzburg
- http://localhost:8080/persons