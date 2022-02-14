
        
// When the user clicks anywhere outside of the login, close it
window.onclick = function(event) {
  if (event.target == login) {
    login.style.display = "none";
  }
}

/*
let login = document.getElementById("form");
login.addEventListener("submit", submitForm);
*/

function printPressed(event){
    console.log(`Key pressed in username field: ${event.key}`);  
}

function passwordPressed(event){
    console.log(`Key pressed in password field: ${event.key}`);
}

let login = document.getElementById("form");
login.addEventListener("submit", submitForm);

function submitForm(event){
    event.preventDefault();
    console.log("We are preventing the default functionality of the form");
    console.log(`The username was ${document.getElementById("username").value}`);
    console.log(`The password was ${document.getElementById("psw").value}`);
    
}