let apiURL = 'http://34.67.71.40:7000/login';

let login = document.getElementById("form");
login.addEventListener("submit", submitForm);

function submitForm(event){
    event.preventDefault();

    var data = new FormData();
    data.append("username", document.getElementById("username").value);
    data.append("password", document.getElementById("password").value);

    fetch(apiURL,{
      method: 'POST',
      body: data      
    })
    .then(response => response.json())
    .then(data =>{
      console.log('Success: ',data);
    })
    .catch((error)=>{
      console.error('Error: ',error);
    })
    
    login.reset();

    //needs to add handling for when password is incorrect
    //needs to add redirection for when successfully logged int; for employee; for manager
}