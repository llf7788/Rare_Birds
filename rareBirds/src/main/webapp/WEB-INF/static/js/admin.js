async function onRoleChange(event) {
    let doc_tr = event.parentElement.parentElement;
    let id = doc_tr.querySelector(".user_id").innerText;
    let role = doc_tr.querySelector(".user_role");

    let data = new URLSearchParams();
    data.append("id", id);
    data.append("role", role.options[role.selectedIndex].value);
    await fetch("/admin/user/role", {
        method: "POST",
        body: data
    }).then(response => response.json())
        .then(res => {
            if (res.success) {
                alert("change role of user: " + name + " success.")
            } else {
                alert(res.error)
            }
        })
}