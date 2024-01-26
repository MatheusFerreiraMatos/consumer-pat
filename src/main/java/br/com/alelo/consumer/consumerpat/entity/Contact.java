package br.com.alelo.consumer.consumerpat.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@Entity
@Table(name = "tb_contacts")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Pattern(regexp = "\\d{10}", message = "O número de telefone móvel deve conter exatamente 10 dígitos.")
    @Column(name = "mobile_phone_number")
    private String mobilePhoneNumber;

    @NotBlank
    @Pattern(regexp = "\\d{8}", message = "O número de telefone residencial deve conter exatamente 8 dígitos.")
    @Column(name = "residence_phone_number")
    private String residencePhoneNumber;

    @NotBlank
    @Pattern(regexp = "\\d{8}", message = "O número de telefone deve conter exatamente 8 dígitos.")
    @Column(name = "phone_number")
    private String phoneNumber;

    @NotBlank
    @Email
    @Column(name = "email")
    private String email;

}
