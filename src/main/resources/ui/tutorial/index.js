import express from 'express';
import fetch from 'node-fetch';

const app = express();
app.listen(3000, () => console.log('listening at 3000'));
app.use(express.static('public'))
app.use(express.json());

const url_frontend_adduser = '/users';
const url_backend_adduser = 'http://localhost:8080/users';

app.post(url_frontend_adduser, (request, response) => {
    console.log('request: post, url: ' + url_frontend_adduser);
    console.log(request.body);
    response.json(request.body);

    //request to backend
    const options = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(request.body)
    };

    fetch(url_backend_adduser, options);

});

const url_frontend_getusers = '/users';
const url_backend_getusers = 'http://localhost:8080/users';

app.get(url_frontend_getusers, (request, response) => {
    console.log('request: get, url: ' + url_frontend_getusers);
    console.log(request.body);
    response.json(request.body);

    //request to backend
    fetch(url_backend_adduser);
    async function getUserswebserver() {

        const response = await fetch(url_backend_getusers);
        const data = await response.json();

    }
});