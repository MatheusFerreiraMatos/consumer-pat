package br.com.alelo.consumer.consumerpat.exception;

import javax.swing.*;

public class CardNumberAlreadyExistsException extends RuntimeException {

    public CardNumberAlreadyExistsException(String message) {
        super(message);
    }

}
