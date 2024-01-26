package br.com.alelo.consumer.consumerpat.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "tb_addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "street")
    private String street;

    @NotNull
    @Min(value = 1, message = "O número deve ser maior que 0.")
    @Column(name = "number")
    private Integer number;

    @NotBlank
    @Column(name = "city")
    private String city;

    @NotBlank
    @Column(name = "country")
    private String country;

    @NotBlank
    @Size(min = 5, max = 8, message = "O código postal deve ter entre 5 e 10 caracteres.")
    @Column(name = "portal_code")
    private String portalCode;

}
