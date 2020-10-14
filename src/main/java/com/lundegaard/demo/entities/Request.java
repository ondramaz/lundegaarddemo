package com.lundegaard.demo.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Getter @Setter @NoArgsConstructor
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "request_kind_id", referencedColumnName = "id")
    RequestKind requestKind;

    @NotNull
    @Pattern(regexp = "^[A-Za-z0-9]+$",message="{validation.onlyAlphanumeric}")
    private String policyNumber;

    @NotNull
    @Size(max=250, message="{validation.name.size}")
    @Pattern(regexp = "^[A-Za-z]+$",message="{validation.onlyAlphabets}")
    private String name;

    @NotNull
    @Size(max=250, message="{validation.surName.size}")
    @Pattern(regexp = "^[A-Za-z]+$",message="{validation.onlyAlphabets}")
    private String surName;

    @Size(max=1000, message="{validation.requestText.size}")
    private String requestText;
}
