package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.FlightSelection;
import ru.netology.repository.FlightRepository;

import static org.junit.jupiter.api.Assertions.*;

class FlightManagerTest {
    private FlightRepository repository =new FlightRepository();
    private FlightManager manager = new FlightManager();

    FlightSelection first = new FlightSelection(1, 1299, "SVO", "KZN", 95);
    FlightSelection second = new FlightSelection(2, 2199, "VKO", "KZN", 95);
    FlightSelection third = new FlightSelection(3, 2385, "VKO", "KZN", 90);
    FlightSelection fourth = new FlightSelection(4, 3100, "DME", "KZN", 90);
    FlightSelection fifth = new FlightSelection(5, 2385, "SVO", "KZN", 95);
    FlightSelection sixth = new FlightSelection(6, 5001, "DME", "SVO", 160);

    void setUp() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
        repository.save(sixth);
    }


    @Test
    void findAllMatchesEqualPriceSort() {
        setUp();
        FlightSelection[] expected = new FlightSelection[]{fifth,third};
        FlightSelection[] actual = manager.findAllMatches("VKO","KZN");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindOne() {
        setUp();
        FlightSelection[] actual = manager.findAllMatches("DME", "KZN");
        FlightSelection[] expected = new FlightSelection[]{fourth};
        assertArrayEquals(expected, actual);
    }

}