
export function saveUser(data) {
    localStorage.setItem("accessToken", data.accessToken);
    localStorage.setItem("username", data.username);
}

export function getUsername() {
    if (!localStorage.getItem("accessToken")) {
        deleteUser();
    }

    return localStorage.getItem("username");
}

export function deleteUser() {
    localStorage.setItem("accessToken", null);
    localStorage.setItem("username", null);
    localStorage.clear();
}
