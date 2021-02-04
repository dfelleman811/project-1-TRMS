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
    let navDiv = document.getElementById('navBar');

    let allRequestsButton = document.createElement('li');
    allRequestsButton.setAttribute('id', 'allRequests');
    allRequestsButton.setAttribute('onclick','getAllDepartmentRequests()');
    allRequestsButton.innerHTML = "View All Department Requests";

    navDiv.append(allRequestsButton);
    
}

function loadBenCo() {
    // if benco
        //eveerything a dept head can do plus..
        // review all requests
        // view all reimbursements
}



// event listener for view requests statuses
// let viewStatus = document.getElementById('viewRequests');
// viewStatus.addEventListener("click", getEmpRequests);


function createRequest() {
    window.location.href="http://localhost:8080/Project-1-TRMS/html/newRequest.html";
}

function getEmpRequests() {

    // get request
    let xhttp = new XMLHttpRequest();

    xhttp.open("GET", "http://localhost:8080/Project-1-TRMS/getEmpRequests.do", true);

    xhttp.send();

    xhttp.onreadystatechange = function() {

        if (this.readyState == 4 && this.status == 200) {
            // get json of request objects
            let responseList = this.responseText;

            // parse to list
            parsedResponseList = JSON.parse(responseList);

            //verify
            console.log(parsedResponseList)

            //make sure response isn't empty
            if (parsedResponseList.length == 0) {
                //print message saying no requests
                // get placeholder table
                let pholder = document.getElementById('resultTables').lastChild;
                // create p element
                let message = document.createElement('p').innerHTML = "There are no results to display. Please choose another option."
                pholder.replaceWith(message);
            }else{
                setUpTable(parsedResponseList);
            }
        }
    }

}

function getAllDepartmentRequests() {

    // get request
    let xhttp = new XMLHttpRequest();

    xhttp.open("GET", "http://localhost:8080/Project-1-TRMS/getAllDeptRequests.do", true);

    xhttp.send();

    xhttp.onreadystatechange = function() {

        if (this.readyState == 4 && this.status == 200) {
            // get json of request objects
            let responseList = this.responseText;

            // parse to list
            parsedResponseList = JSON.parse(responseList);

            //verify
            console.log(parsedResponseList)

            //make sure response isn't empty
            if (parsedResponseList.length == 0) {
                //print message saying no requests
                // get placeholder table
                let pholder = document.getElementById('resultTables').lastChild;
                // create p element
                let message = document.createElement('p').innerHTML = "There are no results to display. Please choose another option."
                pholder.replaceWith(message);
            }else{
                setUpTable(parsedResponseList);
            }
        }
    }


}
function getAllRequests() {

            

    let xhttp = new XMLHttpRequest();

    xhttp.open("GET", "http://localhost:8080/Project-1-TRMS/getAllRequests.do", true);

    xhttp.send();

    xhttp.onreadystatechange = function() {

        if (this.readyState == 4 && this.status == 200) {
            // get json of request objects
            let reqList = this.responseText;

            // parse to list
            parsedReqList = JSON.parse(reqList);

            //verify
            console.log(parsedReqList)

            //make sure response isn't empty
            if (parsedReqList.length == 0) {
                //print message saying no requests
                // get placeholder table
                let pholder = document.getElementById('resultTables').lastChild;
                // create p element
                let message = document.createElement('p').innerHTML = "There are no results to display. Please choose another option."
                pholder.replaceWith(message);
            }else{
                setUpTable(parsedReqList);
            }
        }
    }
}

function setUpTable(parsedReqList) {


        // set up table
        // create list for table head names
        let theaders = [];
        
        // get headers based on type of response
        
        if (Object.keys(parsedReqList[0])[0] == 'requestId') {
            theaders = ['Request ID', 'Submit Date', 'Urgent', 'Status', 'Employee ID', 'Development Resources', 'Actions'];
        } else {
            theaders = ['Payment ID', 'Paid Amount', 'Pay Date','Employee ID', 'Resource ID', 'Request ID'];
        }
        // create empty table
        let table = document.createElement('table');
        table.setAttribute('id', 'newResultTable');

        //create header row
        let hrow = document.createElement('tr');
        hrow.setAttribute('id', 'headers');

        // loop through headers list and create ths
        for (header in theaders) {
            let hname = document.createElement('th');
            hname.innerHTML = theaders[header];
            hrow.append(hname);
        }
        
        // add header row table
        table.append(hrow);

        // add table to page by replacing anytable there already table
        let oldTable = document.getElementById('resultTables').lastChild;
        oldTable.replaceWith(table)
        

        // loop through returned list of requests objects and add to table via function
        let i = 0;
        parsedReqList.forEach(req => {
            printToTable(req, i++);
        }); 

}
function getEmpReimbursements() {

    let xhttp = new XMLHttpRequest();

    xhttp.open("GET", "http://localhost:8080/Project-1-TRMS/getEmpReimbursements.do", true);

    xhttp.send();

    xhttp.onreadystatechange = function() {

        if (this.readyState == 4 && this.status == 200) {
            // get json of request objects
            let reqList = this.responseText;

            // parse to list
            parsedReqList = JSON.parse(reqList);

            //verify
            console.log(parsedReqList)

            //make sure response isn't empty
            if (parsedReqList.length == 0) {
                //print message saying no requests
                // get placeholder table
                let pholder = document.getElementById('resultTables').lastChild;
                // create p element
                let message = document.createElement('p').innerHTML = "There are no results to display. Please choose another option."
                pholder.replaceWith(message);
            }else{
                setUpTable(parsedReqList);
            }
        }
    }

}

function printToTable(req, i) {

    // get table by id
    let t = document.getElementById('newResultTable');
    // create new row and set attributes
    let newRow = document.createElement('tr');
    
    newRow.setAttribute('id', `${i}`);

    // loop through each returned request and set as table data in row
    for (key in req) {
        // create td
        let newData= document.createElement('td');
        newData.setAttribute('name', `${key}`)

        // set inner html of td
        newData.innerHTML= `${req[key]}`;

        // add to new row
        newRow.append(newData);

        // add to table
        t.append(newRow);
    }
    // and add a link for viewing the details
    let viewLink = document.createElement('td');
    viewLink.setAttribute('name', `${i}`)
    viewLink.setAttribute('onclick', `viewDetails(${i})`);
    viewLink.innerHTML = 'View Details';

    newRow.append(viewLink);
}

function viewDetails(i) {

    // how do we get this info and put it on the new page?
    // put into request body of a post and have the session set a new attribute?
    
    //get devresid by td tag name
    let did = document.getElementById(`${i}`).cells[5].innerHTML;
    console.log(did);

    let res = {
        resourceId: did
    }

    //create request object
    let xhttp = new XMLHttpRequest();

    // open request
    xhttp.open("POST", "http://localhost:8080/Project-1-TRMS/getResourceDetails.do", true);

    xhttp.send(JSON.stringify(res));

    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            console.log(this.responseText);
        }

    }
    //window.location.href='http://localhost:8080/Project-1-TRMS/html/devresdetails.html';
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