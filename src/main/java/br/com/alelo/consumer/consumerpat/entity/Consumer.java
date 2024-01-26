package br.com.alelo.consumer.consumerpat.entity;

import br.com.alelo.consumer.consumerpat.controller.dto.request.ConsumerRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
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
    private List<Card> cards = new ArrayList<>();

    public Consumer(ConsumerRequest consumer) {
        this.name = consumer.getName();
        this.documentNumber = consumer.getDocumentNumber();
        this.birthDate = consumer.getBirthDate();
        this.address = consumer.getAddress();
        this.contact = consumer.getContact();
    }

}
