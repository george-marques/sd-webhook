package br.unitins.sd.webhook.socket;

import jakarta.websocket.OnClose;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@ServerEndpoint("/pix/{txid}")
public class WebSocket {

    public static final Map<String, Session> sessions = new ConcurrentHashMap<>();

    @OnOpen
    public void onOpen(Session session, @PathParam("txid") String txid) {
        sessions.put(txid, session);
        log.info("Nova conexão: txid {}", txid);
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        log.info("Mensagem recebida: {}", message);
    }

    @OnClose
    public void onClose(Session session, @PathParam("txid") String txid) {
        sessions.remove(txid);
        log.info("Conexão fechada: txid {}", txid);
    }
}
