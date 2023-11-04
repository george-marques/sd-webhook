package br.unitins.sd.webhook.resource.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PixInfo {
    private String endToEndId;
    private String txid;
    private String valor;
    private ComponentesValor componentesValor;
    private String chave;
    private String horario;
    private String infoPagador;
    private Pagador pagador;
}
