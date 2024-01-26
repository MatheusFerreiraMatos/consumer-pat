package br.com.alelo.consumer.consumerpat.controller.dto.response;

import br.com.alelo.consumer.consumerpat.entity.Card;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class CardResponse {

    private Long id;
    private String type;
    private String number;
    private BigDecimal balance;

    public CardResponse(Card card) {
        this.id = card.getId();
        this.type = String.valueOf(card.getType());
        this.number = card.getNumber();
        this.balance = BigDecimal.ZERO;
    }

}
