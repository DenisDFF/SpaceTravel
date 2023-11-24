package org.example;

import org.flywaydb.core.Flyway;


import org.hibernate.Session;
import org.hibernate.Transaction;


import java.sql.*;
import java.util.List;


public class Main {

    private static Connection connector;

    public static Connection getConnector() {
        return connector;
    }

    public static void main(String[] args) throws SQLException {
        FlywayMigration flywayMigration = new FlywayMigration();
        flywayMigration.Migration();

        ClientDao clientDao = new ClientDao();
        Client client = clientDao.findById(11L);

        PlanetDao planetDao = new PlanetDao();
        Planet fromPlanet = planetDao.findById("MARS");
        Planet toPlanet = planetDao.findById("VENUS");

        Ticket ticket = new Ticket();
        ticket.setClient(client);
        ticket.setFromPlanet(fromPlanet);
        ticket.setToPlanet(toPlanet);

        TicketDao ticketDao = new TicketDao();
        ticketDao.save(ticket);
    }
}