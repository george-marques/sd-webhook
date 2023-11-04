package br.unitins.sd.webhook.resource;

import br.unitins.sd.webhook.resource.model.PixTransaction;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

import java.util.HashMap;
import java.util.Map;

@Path("/api/webhook")
public class WebHookResource {

    @GET
    public Response get() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Manda bala");
        return Response.ok(response).build();
    }

    @POST
    public Response receiveTransaction(PixTransaction pix) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Pix recebido com sucesso!");
        response.put("payload", pix);
        return Response.ok(response).build();
    }
}
