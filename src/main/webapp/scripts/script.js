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

    let xhttp = new XMLHttpRequest();

    xhttp.open("GET", "http://localhost:8080/Project-1-TRMS/session.do", true);

    xhttp.send();

    xhttp.onreadystatechange = function() {

        if (this.readyState == 4 && this.status == 200) {
            
            // load response text (session obj) into variable
            let sessionObj = JSON.parse(this.responseText);
            console.log(sessionObj);
            // check type of employee
            if (sessionObj.firstName.toLowerCase() == 'basic') {
                loadBasicEmployee();
            }

            else if (sessionObj.lastName.toLowerCase() == 'departmenthead') {
                loadDeptHead();
            }
            
            else if (sessionObj.firstName.toLowerCase() == 'benco') {
                loadBenCo()
            }



        }
    }

}

function loadBasicEmployee() {
  // if basic employee
            // can submit requests
            // can view request statuses
            // if no approval in time frame allow employee to alert 
            // can view past reimbursements and remaining reimbursement amount
    

}

function loadDeptHead() {
     // if department head
        // everything a basic employee can do plus....
        // review requests that need approval in their department
            // if they're waiting on benco and no approval in time frame they can alert
        // can view departments requests status reimbursements etc
    let buttonDiv = document.getElementById('buttons');

    let allRequestsButton = document.createElement('div');
    allRequestsButton.setAttribute('id', 'allRequests');
    allRequestsButton.setAttribute('onclick','getAllRequests()');
    allRequestsButton.innerHTML = "View All Department Requests";

    buttonDiv.append(allRequestsButton);


    
}

function loadBenCo() {
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

            parsedReqList.forEach(req => {
                console.log(req);
            }); 
            
            //newDiv.innerHTML = ;



            //body.append(newDiv);



        }
    }
}

function printToTable(req) {

    // test with text first
    let resultDiv = document.createElement('div');
    resultDiv.setAttribute('id', 'resultDiv');

    let nreq = document.createElement('p');
    nreq.innerHTML = req.forEach(thing => req.thing);

    // new table row
    // let table  = document.getElementById('openRequestsTable');
    
    // document.createElement('tr');
}

function logout() {

    // make ajax call and invalidate session

    let xhttp = new XMLHttpRequest();

    xhttp.open("GET", "http://localhost:8080/Project-1-TRMS/logout.do", true);

    xhttp.send();

    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            // return user to index page
            window.location.href="http://localhost:8080/Project-1-TRMS/html/index.html";
        }
    }
    
}