# webflux-demo
Java reactive backend WebFlux example

1. start WebfluxDemoApplication in IDE or ```mvn spring-boot:run```
2. you'll see ```Started WebfluxDemoApplication in 0.948 seconds``` in console
3. issue ```curl 'http://localhost:8080/api/userData?userId=1'``` to test service
4. you should get a json like this one:
```
{"userId":"1","userName":"John","userSurname":"Doe","balance":30000.00,"purchasedMaterials":[{"id":"m1","name":"Gadget #1","purchaseDate":"2023-01-01T12:59:00"},{"id":"m2","name":"Gadget #2","purchaseDate":"2023-01-02T12:59:00"},{"id":"m3","name":"Gadget #3","purchaseDate":"2023-01-03T12:59:00"}]}
```