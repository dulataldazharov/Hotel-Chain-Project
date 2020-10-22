
export function saveUser(data) {
    localStorage.setItem("accessToken", data.accessToken);
    localStorage.setItem("username", data.username);
}

export function getUsername() {
    return localStorage.getItem("username");
}

export function deleteUser(data) {
    localStorage.clear();
}
