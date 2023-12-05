function btnAction() {
    var xhr = new XMLHttpRequest();
    xhr.open('POST', './ServletQueue', true);

    xhr.onload = function () {
        if (xhr.status === 200) {
            var responseText = xhr.responseText;
            document.getElementById('queueList').value = responseText;
            document.getElementById('ops').value = responseText;
        }
    };
    var formData = new FormData(document.getElementById('queueform'));
    xhr.send(formData);
}


