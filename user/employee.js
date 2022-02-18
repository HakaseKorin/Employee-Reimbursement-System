const URL = "http://34.67.71.40:7000";

//include a check here if there is session information;
// if there is session information then the user is logged in;else is not logged in
let uid = window.sessionStorage.getItem("id");

let userProfile = document.getElementById("user-profile");

(async () => {
    fetch(`${URL}/ers_user/${uid}`)
    .then(response => response.json())
    .then(data =>{
        user = data;
        setProfile(user);
    })
    .catch((error)=>{
        console.error('Error: ',error);
    })
})();

let update = document.getElementById('form-profile');
update.addEventListener("submit", updateUser);

function updateUser(event){
    event.preventDefault();
    
    let id = uid;
    let username = document.getElementById('username').value;
    let password = document.getElementById('password').value;
    let firstName = document.getElementById('first-name').value;
    let lastName =  document.getElementById('last-name').value;
    let email = document.getElementById('email').value;

    let userObj = {
        id,
        username,
        password,
        firstName,
        lastName,
        email,
        roleId: "1"
    };

    console.log(userObj);

    fetch(`${URL}/ers_user/${uid}`,{
        method: 'put',
        body: JSON.stringify(userObj)
    }).then(response => response.json())
    .then(data => {
        console.log(data);
        //reload the page
    })
    .catch((error)=>{
        console.error('Error: ',error);
    })
}



function getRole(roleId){
    switch(roleId){
        case 1: return "EMPLOYEE";
        case 2: return "MANAGER";
        default: break;
    }
}

function setProfile(user){
let firstField = document.getElementById('first-name').value = `${user.firstName}`;
let lastField = document.getElementById('last-name').value = `${user.lastName}`;
let userField = document.getElementById('username').value = `${user.username}`;
let emailField = document.getElementById('email').value = `${user.email}`;
let passField = document.getElementById('password').value = `${user.password}`;
let roleField = document.getElementById('role').value = `${getRole(user.roleId)}`;

}
