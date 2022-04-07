async function get() {

    const resp =
        await fetch('http://localhost:8080/api/budgets')
        .then(function(resp) {
            return resp.json();
        })

    .then(function(data) {
        console.log(data);
    })

    .catch(function(error) {
        console.warn('Somethin went wrong!', error);
    });
}

get();

function dataToTable(data) {
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
    <td>${data.validity}</td>
    <td>${data.client.name}</td> 
    <td>${data.client.address}</td>        
    </tr>`;

    });

    document.getElementById("data-table").innerHTML = tab;
}