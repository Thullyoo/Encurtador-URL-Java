package com.thullyoo.encurtaUrl.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_LINKS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Link {

    @Id
    private String id;

    private String originalUrl;

    private LocalDateTime horaCriação;

    private LocalDateTime expiraEm;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] qrCode;

}
