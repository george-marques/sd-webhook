package br.unitins.sd.webhook.resource.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PixTransaction {
    private List<PixInfo> pix;
}

