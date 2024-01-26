package br.com.alelo.consumer.consumerpat.service;

import br.com.alelo.consumer.consumerpat.controller.dto.request.CardRequest;
import br.com.alelo.consumer.consumerpat.controller.dto.response.CardResponse;
import br.com.alelo.consumer.consumerpat.entity.Card;
import br.com.alelo.consumer.consumerpat.entity.Consumer;
import br.com.alelo.consumer.consumerpat.exception.CardNumberAlreadyExistsException;
import br.com.alelo.consumer.consumerpat.respository.CardRepository;
import br.com.alelo.consumer.consumerpat.respository.ConsumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private ConsumerRepository consumerRepository;


    public CardResponse createCard(Long idConsumer, CardRequest request) {
        validateCreation(idConsumer, request);

        Consumer consumer = consumerRepository.getReferenceById(idConsumer);
        Card response = cardRepository.save(new Card(request, consumer));

        return new CardResponse(response);
    }

    private void validateCreation(Long id, CardRequest request) {
        Optional<Consumer> consumer = consumerRepository.findById(id);
        Optional<Card> card = cardRepository.findByNumber(request.getNumber());

        Consumer entityConsumer = consumer.orElseThrow(() -> new EntityNotFoundException("Consumer com id " + id + " não encontrado"));

        if (card.isPresent()) {
            throw new CardNumberAlreadyExistsException("Cartão com esse número já existe.");
        }

    }
}
