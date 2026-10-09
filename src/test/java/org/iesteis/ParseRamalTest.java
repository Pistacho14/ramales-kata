package org.iesteis;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import org.junit.jupiter.api.Test;

class ParseRamalTest {

    @Test
    void uniqueRamal() {
        String ramal = "1\n"
                + "Ana I 100\n";

        List<Ramal> result = ParseRamal.parseRamal(ramal);

        assertEquals(1, result.size());
        assertEquals("Ana", result.get(0).getName());
        assertEquals("I", result.get(0).getDirection());
        assertEquals(100, result.get(0).getDistance());
    }

    @Test
    void doubleUniqueRamal() {
        String ramal = "2\n"
                + "Ana I 100\n"
                + "Pedro I 300\n";

        List<Ramal> result = ParseRamal.parseRamal(ramal);

        assertEquals(2, result.size());
        assertEquals("Ana", result.get(0).getName());
        assertEquals("Pedro", result.get(1).getName());
    }

    @Test
    void mixedDoubleRamal() {
        String ramal = "2\n"
                + "Ana I 100\n"
                + "Pedro D 300\n";

        List<Ramal> result = ParseRamal.parseRamal(ramal);

        assertEquals("Ana", result.get(0).getName());
        assertEquals("I", result.get(0).getDirection());
        assertEquals("Pedro", result.get(1).getName());
        assertEquals("D", result.get(1).getDirection());
    }

    @Test
    void sameDistanceRamal() {
        String ramal = "2\n"
                + "Ana I 300\n"
                + "Pedro D 300\n";

        List<Ramal> result = ParseRamal.parseRamal(ramal);

        assertEquals(300, result.get(0).getDistance());
        assertEquals(300, result.get(1).getDistance());
    }

    @Test
    void normalRamal() {
        String ramal = "5\n"
                + "Ana I 100\n"
                + "Pedro D 300\n"
                + "Luis I 200\n"
                + "Maria D 100\n"
                + "Carlos I 300";

        List<Ramal> resultado = ParseRamal.parseRamal(ramal);

        assertEquals(5, resultado.size());
        assertEquals("Ana", resultado.get(0).getName());
        assertEquals("Pedro", resultado.get(1).getName());
        assertEquals("Luis", resultado.get(2).getName());
        assertEquals("Maria", resultado.get(3).getName());
        assertEquals("Carlos", resultado.get(4).getName());
    }
}
