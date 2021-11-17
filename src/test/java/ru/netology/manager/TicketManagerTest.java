package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {
    private TicketManager manager = new TicketManager(new TicketRepository());

    Ticket first = new Ticket(1, 3500, "LED", "DME", 40);
    Ticket second = new Ticket(2, 4000, "LED", "GOJ", 75);
    Ticket third = new Ticket(3, 6000, "GOJ", "DME", 780);
    Ticket fourth = new Ticket(4, 15000, "DME", "KUF", 80);
    Ticket fifth = new Ticket(5, 4300, "GOJ", "LED", 75);
    Ticket sixth = new Ticket(6, 5000, "LED", "DME", 40);
    Ticket seventh = new Ticket(7, 6400, "DME", "GOJ", 85);
    Ticket eighth = new Ticket(8, 3300, "LED", "DME", 45);


    @Test
    void shouldSaveTicketAndGet() {
        manager.save(first);
        manager.save(second);
        manager.save(fifth);

        Ticket[] actual = manager.getAll("LED", "GOJ");
        Ticket[] expected = new Ticket[]{second};
        assertArrayEquals(actual, expected);
    }

    @Test
    void shouldSaveTicketAndSetFromWithoutTo() {
        manager.save(first);
        manager.save(second);
        manager.save(sixth);

        Ticket[] actual = manager.getAll("LED", "");
        Ticket[] expected = new Ticket[]{};
        assertArrayEquals(actual, expected);
    }

    @Test
    void shouldSaveTicketAndSetToWithoutFrom() {
        manager.save(third);
        manager.save(fourth);
        manager.save(seventh);

        Ticket[] actual = manager.getAll("", "DME");
        Ticket[] expected = new Ticket[]{};
        assertArrayEquals(actual, expected);
    }

    @Test
    void shouldSaveTicketWithoutFromAndTo() {
        manager.save(third);
        manager.save(fourth);
        manager.save(seventh);

        Ticket[] actual = manager.getAll("", "");
        Ticket[] expected = new Ticket[]{};
        assertArrayEquals(actual, expected);
    }

    @Test
    void shouldGetAllFromLedToDme() {
        manager.save(first);
        manager.save(second);
        manager.save(third);
        manager.save(fourth);
        manager.save(fifth);
        manager.save(sixth);
        manager.save(seventh);
        manager.save(eighth);

        Ticket[] actual = manager.getAll("LED", "DME");
        Ticket[] expected = new Ticket[]{eighth, first, sixth};
        assertArrayEquals(actual, expected);
    }

    @Test
    void shouldGetAllFromLedToKuf() {
        manager.save(first);
        manager.save(second);
        manager.save(third);
        manager.save(fourth);
        manager.save(fifth);
        manager.save(sixth);
        manager.save(seventh);
        manager.save(eighth);

        Ticket[] actual = manager.getAll("LED", "KUF");
        Ticket[] expected = new Ticket[]{};
        assertArrayEquals(actual, expected);
    }

    @Test
    void shouldRemoveById() {
        manager.save(first);
        manager.save(second);
        manager.save(third);
        manager.save(fourth);
        manager.save(fifth);
        manager.save(sixth);
        manager.save(seventh);
        manager.save(eighth);

        manager.removeById(1);

        Ticket[] actual = manager.getAll("LED", "DME");
        Ticket[] expected = new Ticket[]{eighth, sixth};
        assertArrayEquals(actual, expected);

    }


}