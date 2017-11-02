var xmlHttp = createXmlHttpRequestObject();

function createXmlHttpRequestObject() {
    var xmlHttp;

    if(window.ActiveXObject) {                  // IE
        try{
            xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
        }   catch (e){
            xmlHttp = false;
        }
    }
    else {                                      // OTHER BROWSERS
        try{
            xmlHttp = new XMLHttpRequest();
        }   catch (e){
            xmlHttp = false;
        }
    }
    if(!xmlHttp) {
        alert('Something went wrong');
    }
}

function process() {
    if(xmlHttp.readyState === 0 || xmlHttp.readyState === 4) {
        var search = encodeURIComponent(document.getElementById("companySearch").value);
        alert(search);
        xmlHttp.open("GET", "/search?search=" + search, true);
        xmlHttp.onreadystatechange = handleServerResponse();
        xmlHttp.send(null);
    }
    else {
        setTimeout('process()', 1000);
    }
}

function handleServerResponse() {
    if(xmlHttp.readyState === 4) {
        if(xmlHttp.status === 200) {
            var xmlResponse = xmlHttp.responseXML;
            var xmlDocumentElement = xmlResponse.documentElement;
            var message = xmlDocumentElement.firstChild.data;
            document.getElementById("ajax").innerHTML = message;

            setTimeout('process()', 1000);
        } else {
            alert('Something went wrong');
        }
    }
}