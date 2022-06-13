async function getUsers() {

    const url = 'http://localhost:3000/users'
    
    const response = await fetch(url);
    const data = await response.json();

    userstable.innerHTML = `
        <thead>
            <tr>
                <th class="mdl-data-table__cell--non-numeric">email</th>
                <th class="mdl-data-table__cell--non-numeric">password</th>
                <th class="mdl-data-table__cell--non-numeric">role</th>
            </tr>
        </thead>
        <tbody id="userstablebody"></tbody>
        `;

    data.forEach(user => {
        userstablebody.innerHTML += `
        <tr>
            <td class="mdl-data-table__cell--non-numeric">${user.email}</td>
            <td class="mdl-data-table__cell--non-numeric">${user.password}</td>
            <td class="mdl-data-table__cell--non-numeric">${user.role}</td>
        </tr>
        `;
    })
}