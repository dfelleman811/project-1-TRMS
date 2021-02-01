 // Define function for log in button click
 function onLoginClick() {

    // collect input from fields

    let emailInput = document.getElementById('emailInput').value;
    let passwordInput = document.getElementById('passwordInput').value;

    console.log(emailInput);
    console.log(passwordInput);

    // Create json object to send in request body

    let employee = {
        email: emailInput,
        password: passwordInput
    }

    // Get employee by email and make sure password matches
    // Create request object
    let xhttp = new XMLHttpRequest();

    // we'll use a put request to send sensitive information in request body not url
    xhttp.open("POST", "http://localhost:8080/Project-1-TRMS/getEmployee.do", true);

    // Set request header
    xhttp.setRequestHeader('Content-Type', 'application/json');

    xhttp.send(JSON.stringify(employee));

    xhttp.onreadystatechange = function() {

        if (this.readyState == 4 && this.status == 200) {
            // redirect to another page
           window.location.href="http://localhost:8080/Project-1-TRMS/html/home.html";

            
        }
    }

}

function onHomePageLoad() {

    // Load appropriate elements based on user permissions

    console.log(request.getSession());
    // if basic employee
        // can submit requests
        // can view request statuses
            // if no approval in time frame allow employee to alert 
        // can view past reimbursements and remaining reimbursement amount

    // if department head
        // everything a basic employee can do plus....
        // review requests that need approval (theirs)
            // if they're waiting on benco and no approval in time frame they can alert
        // can view departments requests status reimbursements etc

    // if benco
        //eveerything a dept head can do plus..
        // review all requests
        // view all reimbursements
}

// event listener for view requests statuses
let viewStatus = document.getElementById('viewRequests');
document.addEventListener("click", viewRequestStatuses());


function createRequest() {
    window.location.href="http://localhost:8080/Project-1-TRMS/html/newRequest.html";
}

function viewRequestStatuses() {
    // stop page from reloading?

    // get employee id from session
    let id = 0;

}

function getAllRequests() {

            

    let xhttp = new XMLHttpRequest();

    xhttp.open("GET", "http://localhost:8080/Project-1-TRMS/getAllRequests.do", true);

    xhttp.send();

    xhttp.onreadystatechange = function() {

        if (this.readyState == 4 && this.status == 200) {
            let reqList = this.responseText;

            let body = document.getElementById('body');
            let newDiv = document.createElement("div");
            
            parsedReqList = JSON.parse(reqList);

            console.log(parsedReqList)

            
            
            //newDiv.innerHTML = ;



            //body.append(newDiv);



        }
    }
}