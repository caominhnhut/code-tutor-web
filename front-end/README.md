# CodeTutor

## Build images
docker build -t code-tutor:2021.1.0 .

## Run container
docker run -v ${PWD}:/app -v /app/node_modules -p 4201:4200 --rm code-tutor:dev