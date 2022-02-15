const URL = "http://34.67.71.40:7000";

let userHeader = new Headers();
userHeader.get("id"); 

let user;
let userProfile = document.getElementById("user-profile");
console.log(userHeader);

(async () => {
    let request = await fetch(`${URL}/ers_user/2`)
    let result = await request.json();
    console.log(result);
    user = result;
    createProfile(user);
})();

function getRole(roleId){
    switch(roleId){
        case 1: return "EMPLOYEE";
        case 2: return "MANAGER";
        default: break;//throw error
    }
}

function createProfile(user){
    let cDiv = document.createElement('div');

    cDiv.innerHTML =`
        <p>First Name: ${user.firstName}</p>
        <p>Last Name: ${user.lastName}</p>
        <p>Username: ${user.username}</p>
        <p>Email: ${user.email}</p>
        <p>Password: ${user.password}</p>
        <p>Role: ${getRole(user.roleId)}</p>
    `;

    userProfile.append(cDiv);
}