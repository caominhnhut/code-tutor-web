# Stage 1: Compile and Build angular codebase

# Use official node image as the base image
FROM node:10.16.3 as builder

# Set the working directory
WORKDIR /app

# add `/app/node_modules/.bin` to $PATH
ENV PATH /app/node_modules/.bin:$PATH

# install and cache app dependencies
COPY package.json /app/package.json

RUN npm install
RUN npm install -g @angular/cli@11.2.4

# add app
COPY . /app

# start app
CMD ng serve --host 0.0.0.0