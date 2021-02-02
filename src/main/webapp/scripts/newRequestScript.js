
let submit = document.getElementById('formSubmit');
submit.addEventListener('click', submitForm);

console.log('before function...');
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

    // call add_request first so this is the first request
    let requestUrgent = {
        isUrgent: urgent
    }

    // then we call add_resource so this info comes second
    let resource = {
        startDate: startDate,
        startTime: startTime,
        endTime: endTime,
        resourceLocation: location,
        cost: cost,
        gradingFormat: format,
        resourcetype: type,
        resourceDescription: description,
        resourceJustification: justification,
    }

    console.log(requestUrgent);
    console.log(resource);
    // send request to create a new request
    // create request object
    // let xhttp = new XMLHttpRequest();

    // xhttp.open("POST", "http://localhost:8080/Project-1-TRMS/addRequest.do", true);

    // //set headers
    // xhttp.setRequestHeader('Content-Type', 'application/json');

    // xhttp.send(JSON.stringify(request));

    // xhttp.onreadystatechange = function() {

    //     if (this.readyState == 4 && this.status == 200) {
    //         console.log
    //     }
    // }



};

