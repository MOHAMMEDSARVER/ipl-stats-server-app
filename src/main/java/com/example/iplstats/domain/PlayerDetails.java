package com.example.iplstats.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "player")
@Getter
@Setter
public class PlayerDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "role")
    private String roleName;
    @Column(name = "team")
    private String teamName;
    @Column(name = "amount")
    private String amount;
    @Column(name = "country")
    private String countryName;
}
