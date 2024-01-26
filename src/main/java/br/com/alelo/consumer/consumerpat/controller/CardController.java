package br.com.alelo.consumer.consumerpat.controller;

import br.com.alelo.consumer.consumerpat.controller.dto.request.CardRequest;
import br.com.alelo.consumer.consumerpat.controller.dto.response.CardResponse;
import br.com.alelo.consumer.consumerpat.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/cards")
public class CardController {

    @Autowired
    private CardService service;

    @PostMapping("/{idConsumer}")
    public ResponseEntity createCard(@PathVariable Long idConsumer,
                                     @RequestBody CardRequest request,
                                     UriComponentsBuilder uriBuilder) {
        CardResponse response = service.createCard(idConsumer, request);

        URI uri = uriBuilder.path("/card/{id}").buildAndExpand(response.getId()).toUri();

        return ResponseEntity.created(uri).body(response);

    }

}
