package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.FlightSelection;
import ru.netology.repository.FlightRepository;

import static org.junit.jupiter.api.Assertions.*;

class FlightManagerTest {
    private FlightRepository repository =new FlightRepository();
    private FlightManager manager = new FlightManager(repository);

    FlightSelection first = new FlightSelection(1, 1299, "SVO", "KZN", 95);
    FlightSelection second = new FlightSelection(2, 2199, "VKO", "KZN", 95);
    FlightSelection third = new FlightSelection(3, 2385, "VKO", "KZN", 90);
    FlightSelection fourth = new FlightSelection(4, 3100, "DME", "KZN", 90);
    FlightSelection fifth = new FlightSelection(5, 2385, "SVO", "KZN", 95);
    FlightSelection sixth = new FlightSelection(6, 5011, "DME", "SVO", 160);
    FlightSelection seventh = new FlightSelection(7, 5031, "DME", "SVO", 140);
    FlightSelection eighth = new FlightSelection(8, 5021, "DME", "SVO", 180);
    FlightSelection ninth = new FlightSelection(9, 1578, "DME", "VKO", 150);
    FlightSelection tenth = new FlightSelection(10, 3100, "KZN", "DME", 100);

    void setUp() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
        repository.save(sixth);
        repository.save(seventh);
        repository.save(seventh);
        repository.save(ninth);
        repository.save(tenth);
    }


    @Test
    void findAllMatchesPriceSortAsc() { //Найти все совпадения,сортировать по цене от меньшего к большему
        setUp();
        FlightSelection[] expected = new FlightSelection[]{sixth,seventh,seventh};
        FlightSelection[] actual = manager.findAllMatches("DME","SVO");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindOne() {
        setUp();
        FlightSelection[] actual = manager.findAllMatches("DME", "KZN");
        FlightSelection[] expected = new FlightSelection[]{fourth};
        assertArrayEquals(expected, actual);
    }
    @Test
    void FindIfNotExist() {
        setUp();
        FlightSelection[] expected = new FlightSelection[0];
        FlightSelection[] actual = manager.findAllMatches("SVO", "DME");
        assertArrayEquals(expected, actual);
    }
    @Test
    void NotFindOneElementRepo() {
        repository.save(first);
        FlightSelection[] actual = manager.findAllMatches("SVO", "SVO");
        FlightSelection[] expected = new FlightSelection[0];
        assertArrayEquals(expected, actual);
    }
    @Test
    void FindOneElementRepo() {
        repository.save(tenth);
        FlightSelection[] actual = manager.findAllMatches("KZN", "DME");
        FlightSelection[] expected = new FlightSelection[]{tenth};
        assertArrayEquals(expected, actual);
    }
    @Test
    void shouldNotFindEmptyRepo() {
        FlightSelection[] actual = manager.findAllMatches("SVO", "SVO");
        FlightSelection[] expected = new FlightSelection[0];
        assertArrayEquals(expected, actual);
    }

}