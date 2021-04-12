# CodeTutor

## Build images
docker build -t code-tutor:2021.1.0 .

## Run container
docker run -v ${PWD}:/app -v /app/node_modules -p 4201:4200 --rm code-tutor:dev

## Run docker compose on dev
docker-compose up -d --build

## Run docker compose files on production
docker-compose -f docker-compose-prod.yml up -d --build