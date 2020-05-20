# Phone-shop
This is Rest project create with Spring Boot and MongoDB.
In project i avoid usage of querydsl, and i used standard @Query
annotation. Application simple shows documents from mongoDB to
client. We can use many filters in api to specified
what Rest should return. In project, I use MongoDB compass and 
Intellij.
## Folders and explanation

* `src\main\java\com\matthewksc\phoneshop\controller:` - folder with basic rest controller to 
send data in json to web
* `src\main\java\com\matthewksc\phoneshop\dao:` - folder with data logic,
entity's and repository
* `src\main\java\com\matthewksc\phoneshop\service:` - service to make operations 
on data
* `src\main\java\com\matthewksc\phoneshop\init.java:` - simple init of data

## MongoDB compass 

**Simple connection with a database on default port** (same in application.yml)
![Alt text](https://github.com/MatthewKsc/phone-shop/blob/master/src/main/resources/static/conncection.png?raw=true "mongoCompass")
<br>
<br>
**This show's result's in Mongo Compass**
![Alt text](https://github.com/MatthewKsc/phone-shop/blob/master/src/main/resources/static/mongoCompass.png?raw=true "mongoCompass")
