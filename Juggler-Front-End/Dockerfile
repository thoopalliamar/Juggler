FROM node:latest
RUN mkdir -p /juggler
WORKDIR /juggler
COPY package.json /juggler/
RUN npm install --force
RUN npm cache verify
COPY . /juggler
EXPOSE 4200/tcp
CMD ["npm", "start", "--", "--host", "0.0.0.0", "--poll", "2000"]


