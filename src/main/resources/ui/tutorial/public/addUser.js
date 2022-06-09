async function addUser() {

    const url = 'http://localhost:3000/users';
    
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

    fetch(url, options);

}