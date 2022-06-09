//const express = require('express');
import express from 'express';
import fetch from 'node-fetch';
const app = express();
app.listen(3000, () => console.log('listening at 3000'));
app.use(express.static('public'))
app.use(express.json());

app.post('/api', (request, response) => {
    console.log('I got a request');
    console.log(request.body);
    response.json({
        status: 'success',
        body: request.body
    });



    const url = 'http://localhost:8080/users';

    const options = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: request.body
    };

    fetch(url, options);

});