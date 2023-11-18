const socket = new WebSocket('ws://localhost:8080/websocket');

socket.addEventListener('open', (event) => {
    console.log('Conexão aberta:', event);
    socket.send('Olá, servidor!');
});

socket.addEventListener('message', (event) => {
    console.log('Mensagem recebida do servidor:', event.data);
});

socket.addEventListener('error', (event) => {
    console.error('Erro na conexão:', event);
});

socket.addEventListener('close', (event) => {
    if (event.wasClean) {
        console.log('Conexão fechada de forma limpa, código:', event.code, 'razão:', event.reason);
    } else {
        console.error('Conexão fechada de forma abrupta');
    }
});

function pay(e) {
    e.preventDefault()
    const txidElement = document.getElementById("txid");
    const txid = txidElement.value;

    return fetch("http://localhost:8080/api/webhook", {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(txid),
    })
        .then((response) => {
            if (!response.ok) {
                throw new Error('Erro na solicitação POST');
            }
            return response.json();
        })
        .then((responseData) => {
            return responseData;
        })
        .catch((error) => {
            throw error;
        });
}
