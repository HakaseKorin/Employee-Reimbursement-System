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

      //checks the type of the user and redirects to the proper page

      location.assign('employeeHome.html');
    })
    .catch((error)=>{
      console.error('Error: ',error);
      login.reset();
    })
    
}
    //needs to add handling for when password is incorrect