# start-io-home-assignment
Home assignment Start.io 

Before runnig start redis docker with command

docker run -it -d -p 6379:6379 --name MY_REDIS -e REDIS_PASSWORD=1234 redis

Run GET request in a postman

localhost:8080/listings?min_price=0.0081&max_price=0.15&min_min_cpm=1&max_min_cpm=2

The answer is peageable, the default values are page=0, size=20

You can run a request with peageable parameters

localhost:8080/listings?min_price=0.0081&max_price=0.15&min_min_cpm=1&max_min_cpm=2&page=10&size=2

In future version I will implement an asyncrony request to database.
