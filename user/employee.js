const URL = "http://34.67.71.40:7000";

//include a check here if there is session information;
// if there is session information then the user is logged in;else is not logged in
let uid = window.sessionStorage.getItem("id");

let user;
let userProfile = document.getElementById("user-profile");

(async () => {
    let request = await fetch(`${URL}/ers_user/${uid}`)
    let result = await request.json();
    console.log(result);
    user = result;
    setProfile(user);
})();


function getRole(roleId){
    switch(roleId){
        case 1: return "EMPLOYEE";
        case 2: return "MANAGER";
        default: break;
    }
}

function setProfile(user){

let cDiv = document.createElement('div');
cDiv.innerHTML =`
    <form action="" class="form-profile">
        <div>
            <label for="">First Name</label>
            <input type="text" name="first-name" id="first-name" value="${user.firstName}">
        </div>
        <div>
            <label for="">Last Name</label>
            <input type="text" name="last-name" id="last-name" value="${user.lastName}">
        </div>
        <div>
            <label for="">Username</label>
            <input type="text" name="username" id="username" value="${user.username}">
        </div>
        <div>
            <label for="">E-mail</label>
            <input type="text" name="email" id="email" value="${user.email}">
        </div>
        <div>
            <label for="">Password</label>
            <input type="text" name="password" id="password" value="${user.password}">
        </div>
        <div>
            <label for="">Role</label>
            <input read only name="role" id="role" value="${getRole(user.roleId)}">
        </div>
    </form>
`;

userProfile.append(cDiv);
}
