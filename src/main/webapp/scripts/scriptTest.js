// Test Click
function testClick() {
    // Testing to see if we can send a request by clicking the button and get a response

    // Create request object
    let xhttp = new XMLHttpRequest();

    // set up URL
    let url = "http://localhost:8080/Project-1-TRMS/MainServlet";

    // Open request
    xhttp.open("GET", url);

    // Send request
    xhttp.send();

    // manage request
    xhttp.onreadystatechange = function() {

        if (this.readyState == 4 && this.status == 200) {
            console.log('Successful response');
        }
    }



}