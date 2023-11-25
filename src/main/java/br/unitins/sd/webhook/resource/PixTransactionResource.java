package br.unitins.sd.webhook.resource;

import br.unitins.sd.webhook.model.PixTransaction;
import br.unitins.sd.webhook.socket.WebSocket;
import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import jakarta.websocket.Session;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/webhook")
public class PixTransactionResource {

    @CheckedTemplate(requireTypeSafeExpressions = false)
    public static class Templates {
        public static native TemplateInstance index();
    }

    @GET
    @Path("/")
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance index() {
        return Templates.index();
    }

    @POST
    public Response postMessage(PixTransaction pixTransaction) {
        String txid = pixTransaction.getPix().get(0).getTxid();
        Session session = WebSocket.sessions.get(txid);
        if (session != null && session.isOpen()) {
            session.getAsyncRemote().sendText("Pix pago com sucesso!");
            return Response.ok("Mensagem enviada para txid: " + txid).build();
        }
        String message = "txid não encontrado ou conexão fechada";
        return Response.status(Response.Status.NOT_FOUND).entity(message).build();
    }
}
