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
            xmlHttp = new XMLHttpRequest("Microsoft.XMLHTTP");
        }   catch (e){
            xmlHttp = false;
        }
    }
    if(!xmlHttp) {
        alert("Can't do that!");
    }

}