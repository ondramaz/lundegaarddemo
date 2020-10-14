package com.lundegaard.demo.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Getter @Setter @NoArgsConstructor
public class RequestKind {

    @Id
    @Column(name = "id")
    private long id;

    @NotNull
    @Size(min = 1, max = 100)
    private String code;

    @NotNull
    @Size(min = 1, max = 1000)
    private String optionText;
}