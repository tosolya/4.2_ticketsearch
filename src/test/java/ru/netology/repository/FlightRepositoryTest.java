package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.FlightSelection;

import static org.junit.jupiter.api.Assertions.*;

class FlightRepositoryTest {
    private FlightRepository repository = new FlightRepository();
    FlightSelection first = new FlightSelection(1, 1299, "SVO", "KZN", 95);
    FlightSelection second = new FlightSelection(2, 2199, "VKO", "KZN", 95);
    FlightSelection third = new FlightSelection(3, 2385, "VKO", "KZN", 90);
    FlightSelection fourth = new FlightSelection(4, 3100, "DME", "KZN", 90);
    FlightSelection fifth = new FlightSelection(5, 4114, "SVO", "KZN", 95);
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
    void shouldSave() {
        repository.save(second);
        FlightSelection[] expected = new FlightSelection[]{second};
        assertArrayEquals(expected,repository.getAll());
    }

    @Test
    void shouldGetAll() {
        setUp();
        FlightSelection[] expected = new FlightSelection[]{first,second,third,fourth,fifth,sixth};
        assertArrayEquals(expected,repository.getAll());
    }

    @Test
    void shouldRemoveById() {
        setUp();
        repository.removeById(4);
        FlightSelection[] expected = new FlightSelection[]{first,second,third,fifth,sixth};
        assertArrayEquals(expected,repository.getAll());
    }
    @Test
    public void wrongInput() {
        Throwable exception = assertThrows(NegativeArraySizeException.class,
                () -> {repository.removeById(9);});
    }

}