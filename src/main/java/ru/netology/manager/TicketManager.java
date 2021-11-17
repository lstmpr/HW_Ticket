package ru.netology.manager;

import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;

public class TicketManager {
    private TicketRepository repository;

    public TicketManager(TicketRepository repository) {
        this.repository = repository;
    }

    public void save(Ticket item) {
        repository.save(item);
    }

    public Ticket[] getAll(String from, String to) {
        Ticket[] items = new Ticket[0];
        for (Ticket ticket : repository.findAll()) {
            if (ticket.getFromAirport() == from && ticket.getToAirport() == to) {
                Ticket[] tmp = new Ticket[items.length + 1];
                System.arraycopy(items, 0, tmp, 0, items.length);
                tmp[tmp.length - 1] = ticket;
                items = tmp;
            }
        }
        Arrays.sort(items);
        return items;
    }

    public void removeById(int id) {
        repository.removeById(id);
    }

}
