async function sendPostToWebserver() {

    const url = 'http://localhost:3000/api';
    
    const email = document.getElementById("emailfieldwebservertest").value;
    const password = document.getElementById("passwordfieldwebservertest").value;
    const role = document.getElementById("rolefieldwebservertest").value;

    const data = {email, password, role};

    const options = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    };

    const responsebody = await fetch(url, options)
    const responsedata = await responsebody.json();
    console.log(responsedata);

}