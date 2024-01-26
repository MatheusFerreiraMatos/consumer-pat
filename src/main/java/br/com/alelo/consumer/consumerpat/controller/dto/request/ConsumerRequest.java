package br.com.alelo.consumer.consumerpat.controller.dto.request;

import br.com.alelo.consumer.consumerpat.entity.Address;
import br.com.alelo.consumer.consumerpat.entity.Contact;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
public class ConsumerRequest {

    @NotBlank
    @Size(min = 2, max = 100, message = "O nome deve ter entre 2 e 100 caracteres.")
    private String name;

    @NotBlank
    @Size(min = 5, max = 20, message = "O número do documento deve ter entre 5 e 20 caracteres.")
    private String documentNumber;

    @NotNull
    @Past
    private LocalDate birthDate;

    @Valid
    private Address address;

    @Valid
    private Contact contact;


}
