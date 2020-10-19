const BACKEND_API_URL = process.env.REACT_APP_BACKEND_API_URL

function formatParams(params) {
    return "?" + Object
        .keys(params)
        .map(function (key) {
            return key + "=" + encodeURIComponent(params[key])
        })
        .join("&")
}

function sendRequest(method, endpoint, callback, data) {
    let jsonData;
    let params = "";
    if (method === "POST" && data) {
        jsonData = JSON.stringify(data);
    }
    if (method === "GET") {
        params = formatParams(data);
    }

    const xhr = new XMLHttpRequest();
    const url = BACKEND_API_URL + endpoint;
    const authToken = localStorage.getItem("authToken");

    xhr.responseType = "json";
    xhr.open(method, url + params);
    xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    if (authToken)
        xhr.setRequestHeader("Authorization", "Token " + authToken);
    xhr.onload = () => {
        callback(xhr.response, xhr.status);
    }
    xhr.onerror = (e) => {
        console.log(e);
        callback({ "message": "Error request" }, 400);
    }
    xhr.send(jsonData);
}

export function registerUser(data, callback) {
    sendRequest("POST", `/api/auth/signup`, callback, data);
}

export function loginUser(data, callback) {
    sendRequest("POST", `/api/auth/signin`, callback, data);
}
