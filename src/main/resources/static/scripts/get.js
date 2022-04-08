function get(event) {
    fetch('http://localhost:8080/api/budgets')
        .then(function(resp) {
            return resp.json();
        })
        .then(function(data) {
            console.log(data)
            dataToTable(data)
        })
        .catch(function(error) {
            console.warn('Something went wrong!', error);
        });
}

function dataToTable(data) {
    console.log(data);
    list = data;
    let tab =
        `<tr>
    <th>ID</th>
    <th>Validity (days)</th>
    <th>Client Name</th>
    <th>Client Address</th>
    </tr>`;

    list.forEach(data => {
        tab += `<tr"> 
    <td>${data.id} </td>
    /<td>${data.validity}</td>
    <td>${data.client.name}</td> 
    <td>${data.client.address}</td>
    <td><a>Update</a></td>
    <td><a>Delete</a></td>
    </tr>`;
    });

    document.getElementById("data-table").innerHTML = tab;
}