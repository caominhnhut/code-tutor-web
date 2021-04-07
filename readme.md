1 - Clone project from: https://github.com/caominhnhut/hacker-monster.git
2 - Install Maven
3 - Install PostgresSQL
4 - Install PGAdmin V4
5 - Start PostgresSQL and
    5.1 - Create a database and name it as: 'hacker-monster'
    5.2 - Create a user for PostgresSQL name it as: 'fx' and password as 'root'
6 - Open terminal or cmd and move to parent project (hacker-monster) and build project by using the command: mvn clean install
7 - Open terminal or cmd and move to hacker-monster/hm-rest and run project by using the command: mvn spring-boot:run
8 - Check the database and make sure the tables is generated correctly.
9 - Check the UI. Access this link: http://localhost:8181/#/ the client site should display

