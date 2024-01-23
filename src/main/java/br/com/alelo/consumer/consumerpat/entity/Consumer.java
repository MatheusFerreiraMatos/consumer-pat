package br.com.alelo.consumer.consumerpat.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "tb_consumers")
public class Consumer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "document_number")
    private String documentNumber;
    @Column(name = "birth_date")
    private LocalDate birthDate;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_address")
    private Address address;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_contact")
    private Contact contact;
    @OneToMany(mappedBy = "consumer")
    private List<Card> cards;

}
