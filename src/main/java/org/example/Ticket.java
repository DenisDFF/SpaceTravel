package org.example;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Table(name = "Ticket")
@Data
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @ManyToOne
    @JoinColumn(name = "from_planet_id", nullable = false)
    private Planet fromPlanet;

    @ManyToOne
    @JoinColumn(name = "to_planet_id", nullable = false)
    private Planet toPlanet;

    public Ticket() {
        this.createdAt = new Timestamp(System.currentTimeMillis());
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setFromPlanet(Planet fromPlanet) {
        this.fromPlanet = fromPlanet;
    }

    public void setToPlanet(Planet toPlanet) {
        this.toPlanet = toPlanet;
    }
}
