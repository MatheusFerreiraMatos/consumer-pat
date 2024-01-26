package br.com.alelo.consumer.consumerpat.controller.dto.request;

import br.com.alelo.consumer.consumerpat.entity.Consumer;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CardRequest {

    private String type;
    private String number;

}
