*How to prepare environment*

1. Install java 11 to your local machine
1. Install docker to your local machine
1. Run `docker run -d --hostname mysql-host --name home-mysql-bookstore -e MYSQL_DATABASE=bookstore -e MYSQL_USER=username -e MYSQL_PASSWORD=password -e MYSQL_ROOT_PASSWORD=root -p 127.0.0.1:3306:3306 mysql:5.6` to install local database
1. Run migration (tempo copy migration script from etc/migration and run it in the mysql container)


*How to build bookeyman*

1. mvn clean install -DskipTests (tempo without tests)
1. java -jar target/store-0.0.1-SNAPSHOT.jar
