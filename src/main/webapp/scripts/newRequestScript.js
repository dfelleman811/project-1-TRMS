
let submit = document.getElementById('formSubmit');
submit.addEventListener('click', submitForm);


function onNewRequestLoad() {

    let xhttp = new XMLHttpRequest();

    xhttp.open("GET", "http://localhost:8080/Project-1-TRMS/session.do", true);

    xhttp.send();

    xhttp.onreadystatechange = function() {

        if (this.readyState == 4 && this.status == 200) {
            
            // load response text (session obj) into variable
            let sessionObj = JSON.parse(this.responseText);
            console.log(sessionObj);
        }
    }
}

function submitForm() {

    // collect all inputs

    let startDate = document.getElementById('startDate').value;

    let startTime = document.getElementById('startTime').value;

    let endTime = document.getElementById('endTime').value;

    let location = document.getElementById('location').value;

    let cost = document.getElementById('cost').value;

    let format = document.getElementById('grade').value;

    let type = document.getElementById('type').value;

    let description = document.getElementById('description').value;

    let justification = document.getElementById('justification').value;

    let urgent = document.getElementById('urgent').value;
    if (urgent == 'yes') {
        urgent = 1;
    }else{
        urgent=0;
    }

    // call add_request first so this is the first request
    let requestUrgent = {
        isUrgent: urgent
    }

    // then we call add_resource so this info comes second
    let resource = {
        startDate: startDate,
        resourceTime: startTime,
        endTime: endTime,
        resourceLocation: location,
        resourceCost: cost,
        gradingFormatId: format,
        resourceType: type,
        resourceDescription: description,
        resourceJustification: justification,
    }

    console.log(requestUrgent);
    console.log(resource);


    // send request to create a new request
    // create request object
    let xhttp = new XMLHttpRequest();

    xhttp.open("POST", "http://localhost:8080/Project-1-TRMS/addRequest.do", true);

    //set headers
    xhttp.setRequestHeader('Content-Type', 'application/json');

    xhttp.send(JSON.stringify(requestUrgent));

    xhttp.onreadystatechange = function() {

        if (this.readyState == 4 && this.status == 200) {
            console.log(this.responseText);
        }
    }

    let xhttp2 = new XMLHttpRequest();

    xhttp2.open('POST', "http://localhost:8080/Project-1-TRMS/addDevRes.do", true);

    xhttp2.send(JSON.stringify(resource));

    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            console.log(this.responseText);
            window.location.href="http://localhost:8080/Project-1-TRMS/html/home.html";
        }
    }



}
