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

    public ConsumerResponse(Consumer consumerResponse) {
        this.id = consumerResponse.getId();
        this.name = consumerResponse.getName();
        this.documentNumber = consumerResponse.getDocumentNumber();
        this.birthDate = consumerResponse.getBirthDate();
        this.address = consumerResponse.getAddress();
        this.contact = consumerResponse.getContact();
        this.cards = consumerResponse.getCards();
    }

}
