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
    const authToken = localStorage.getItem("accessToken");

    xhr.responseType = "json";
    xhr.open(method, url + params);
    xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    if (authToken)
        xhr.setRequestHeader("Authorization", "Bearer " + authToken);
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

export function loadUserInfo(callback) {
    sendRequest("GET", `/api/user/profile/personal`, callback, {});
}

export function loadUserActiveBookings(callback) {
    sendRequest("GET", `/api/reservation/profile/active`, callback, {});
}

export function loadUserPastBookings(callback) {
    sendRequest("GET", `/api/reservation/profile/past`, callback, {});
}

export function loadUserFutureBookings(callback) {
    sendRequest("GET", `/api/reservation/profile/future`, callback, {});
}

export function searchRooms(data, callback) {
    sendRequest("POST", `/api/search-rooms`, callback, data);
}

export function cancelBooking(id, callback) {
    sendRequest("DELETE", `/api/reservation/${id}/cancel`, callback, {});
}
export function makeBooking(data, callback) {
    sendRequest("POST", `/api/reservation/create`, callback, data);
}
export function loadEmployees(callback) {
    sendRequest("GET", `/api/employee/list`, callback, {});
}
export function updateEmployee(data, callback, params) {
    sendRequest("POST", `/api/employee/update` + params, callback, data);
}