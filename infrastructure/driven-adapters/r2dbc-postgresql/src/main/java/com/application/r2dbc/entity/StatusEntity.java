package com.application.r2dbc.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDate;

@Table("\"status\"")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StatusEntity {

    @Id
    @Column("status_id")
    private Long statusId;
    private String name;
    private String description;

}
