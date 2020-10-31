
export function saveUser(data) {
    sessionStorage.setItem("accessToken", data.accessToken);
    sessionStorage.setItem("username", data.username);
}

export function getUsername() {
    if (!sessionStorage.getItem("accessToken")) {
        deleteUser();
    }

    return sessionStorage.getItem("username");
}

export function deleteUser() {
    sessionStorage.setItem("accessToken", null);
    sessionStorage.setItem("username", null);
    sessionStorage.clear();
}
