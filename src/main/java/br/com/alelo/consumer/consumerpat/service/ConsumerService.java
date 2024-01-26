package br.com.alelo.consumer.consumerpat.service;

import br.com.alelo.consumer.consumerpat.controller.dto.request.ConsumerRequest;
import br.com.alelo.consumer.consumerpat.controller.dto.response.ConsumerResponse;
import br.com.alelo.consumer.consumerpat.entity.Consumer;
import br.com.alelo.consumer.consumerpat.respository.ConsumerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    private ConsumerRepository repository;

    public ConsumerService(ConsumerRepository repository) {
        this.repository = repository;
    }

    public Page getConsumers(Pageable pageable) {
        return repository.findAll(pageable).map(ConsumerResponse::new);
    }

    public ConsumerResponse createConsumer(ConsumerRequest consumerRequest) {
        Consumer createConsumer = repository.save(new Consumer(consumerRequest));
        return new ConsumerResponse(createConsumer);
    }
}
