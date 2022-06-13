async function addUser() {

    const url = 'http://localhost:3000/users';
    
    const email = document.getElementById("emailfield").value;
    const password = document.getElementById("passwordfield").value;
    const role = document.getElementById("rolefield").value;

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