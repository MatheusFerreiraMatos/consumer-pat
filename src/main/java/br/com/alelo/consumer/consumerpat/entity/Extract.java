package br.com.alelo.consumer.consumerpat.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "tb_extracts")
@NoArgsConstructor
public class Extract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_description")
    private String productDescription;

    @Column(name = "date_buy")
    private Date dateBuy;

    @Column(name = "amount")
    private double amount;

    @ManyToOne
    @JoinColumn(name = "fk_card")
    private Card card;

    @ManyToOne
    @JoinColumn(name = "fk_establishment")
    private Establishment establishment;

}
