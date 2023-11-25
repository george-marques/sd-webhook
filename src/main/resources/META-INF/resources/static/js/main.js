let ws;

function connect() {
    const txid = document.getElementById("txid").value
    ws = new WebSocket("ws://localhost:8080/pix/" + txid);

    ws.onopen = function () {
        console.log("Conexão aberta para TabID:", txid);
    };

    ws.onmessage = function (event) {
        displayMessage(event.data)
    };

    ws.onclose = function () {
        console.warn("Conexão fechada");
    };
}

function displayMessage(message) {
    const messageDiv = document.getElementById("messages");
    const messageElement = document.createElement("p");
    messageElement.textContent = "Mensagem recebida: " + message;
    messageDiv.appendChild(messageElement);
}