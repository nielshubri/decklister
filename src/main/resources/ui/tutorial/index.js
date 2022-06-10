import express from 'express';
import fetch from 'node-fetch';

const app = express();
app.listen(3000, () => console.log('listening at 3000'));
app.use(express.static('public'))
app.use(express.json());

//frontend urls
const url_frontend_adduser = '/users';
const url_frontend_getusers = '/users';

app.post(url_frontend_adduser, (request, response) => {

    const url_backend_adduser = 'http://localhost:8080/users';

    console.log('request: post, url: ' + url_frontend_adduser);
    console.log(request.body);

    //request to backend
    const options = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(request.body)
    };

    fetch(url_backend_adduser, options);

    //response
    response.json(request.body);
});

app.get(url_frontend_getusers, (request, response) => {

    const url_backend_getusers = 'http://localhost:8080/users';

    console.log('request: get, url: ' + url_frontend_getusers);
    console.log(request.body);


    //request to backend
    async function getUsers() {

        const response = await fetch(url_backend_getusers);
        const data = await response.json();
        console.log(data);

    }

    const promise = getUsers();  

    console.log(promise);

    //response
    response.json(promise.body);
});