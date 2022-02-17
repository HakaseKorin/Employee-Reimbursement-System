const URL = "http://34.67.71.40:7000";

let reimbursementTable = document.getElementById('reimbursement-table');
let uid = window.sessionStorage.getItem("id");
var name = "";
(async () => {
    fetch(`${URL}/reimbursement/1`)
    .then(request => request.json())
    .then(data =>{
        console.log(data);
        appendTable(data);
    })
    .catch((error)=>{
        console.error('Error: ',error);
    })
})();

function getDateTime(timestamp){
    return new Date(timestamp);
}

function getStatus(statusId){
    switch(statusId){
        case 1: return "PENDING";
        case 2: return "ACCEPTED";
        case 3: return "REJECTED";
        default: break;
    }
}

function getType(typeId){
    switch(typeId){
        case 1: return "LODGING";
        case 2: return "FOOD";
        case 3: return "TRAVEL";
        case 4: return "OTHER";
        default: break;
    }
}

function appendTable(results){
    for(var result of results){

        var author = getUser(result.author);
        var reviewer = getUser(result.resolver);
        console.log(author);

        var row = reimbursementTable.insertRow();

        var typeCell = row.insertCell();
        var submitCell = row.insertCell();
        var resolvedCell = row.insertCell();
        var descCell = row.insertCell();
        var amountCell = row.insertCell();
        var authorCell = row.insertCell();
        var reviewerCell = row.insertCell();
        var statusCell = row.insertCell();
    
        typeCell.innerHTML = `${getType(result.typeId)}`;
        submitCell.innerHTML = `${getDateTime(result.submitted)}`;
        resolvedCell.innerHTML = `${getDateTime(result.resolved)}`;
        descCell.innerHTML = result.description;
        amountCell.innerHTML = result.amount;
        authorCell.innerHTML = author.lastName;
        reviewerCell.innerHTML = reviewer.lastName;
        statusCell.innerHTML = `${getStatus(result.statusId)}`;
    }
}

function getUser(userId){
    return fetch(`${URL}/ers_user/${userId}`)
    .then(result => result.json())
    .catch((error)=>{
        console.error('Error: ',error);
      })
}