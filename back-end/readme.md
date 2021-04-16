# Back-End Code Tutor

## Installation
- Install the docker to the machine
- Go to code-tutor-web/document/compose-postgres-master to start the PostgresSQL database
```bash
docker-compose up -d
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