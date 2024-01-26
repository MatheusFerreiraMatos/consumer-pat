package br.com.alelo.consumer.consumerpat.entity;

import br.com.alelo.consumer.consumerpat.controller.dto.request.CardRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_cards")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private CardType type;

    @Column(name = "number")
    private String number;

    @Column(name = "balance")
    private BigDecimal balance;

    @ManyToOne
    @JoinColumn(name = "fk_consumer")
    private Consumer consumer;

    public enum CardType {
        FOOD,
        FUEL,
        DRUGSTORE
    }

    public Card(CardRequest request, Consumer consumer) {
        this.type = CardType.valueOf(request.getType());
        this.number = request.getNumber();
        this.consumer = consumer;
    }

}
