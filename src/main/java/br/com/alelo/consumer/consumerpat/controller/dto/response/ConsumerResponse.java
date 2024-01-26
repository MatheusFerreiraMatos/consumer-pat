package br.com.alelo.consumer.consumerpat.controller.dto.response;

import br.com.alelo.consumer.consumerpat.entity.Address;
import br.com.alelo.consumer.consumerpat.entity.Card;
import br.com.alelo.consumer.consumerpat.entity.Consumer;
import br.com.alelo.consumer.consumerpat.entity.Contact;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
@AllArgsConstructor
public class ConsumerResponse {

    private Long id;
    private String name;
    private String documentNumber;
    private LocalDate birthDate;
    private Address address;
    private Contact contact;
    private List<Card> cards;

    public ConsumerResponse(Consumer consumer) {
        this.id = consumer.getId();
        this.name = consumer.getName();
        this.documentNumber = consumer.getDocumentNumber();
        this.birthDate = consumer.getBirthDate();
        this.address = consumer.getAddress();
        this.contact = consumer.getContact();
        this.cards = consumer.getCards();
    }

}
