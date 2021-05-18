# Back-End Code Tutor

## Installation
- Install the docker to the machine
- Go to code-tutor-web/back-end to start the PostgresSQL database
```bash
docker-compose -f .\docker-compose.postgres.yml up -d
```
- Open CLI in Docker-Desktop to access database and see if it works with this syntax: psql -U <user-name> -W <database-name>
```
psql -U postgres -W code-tutor
```

## Usage
- Run the class CodeTutorApplication
- Check the api to make sure the back-end works well
    - http://localhost:8080/api/no-auth/health-check
    
* Authentication:
    - http://localhost:8080/api/authenticate
        - Guess user:
         ```bash
             username: guess@gmail.com
             password: 123
         ```
      
        - Student user:
        ```bash
            username: student@gmail.com
            password: 123
        ```
                     
        - Teacher user:
        ```bash
            username: teacher@gmail.com
            password: 123
        ```