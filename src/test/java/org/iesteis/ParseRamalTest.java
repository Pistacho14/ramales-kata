package org.iesteis;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ParseRamalTest {

    @Test
    public void ramalUnico() {
        String ramal = "1\n"
                + "Ana I 100\n";

        List<Ramal> resultado = ParseRamal.parseRamal(ramal);

        assertEquals(1, resultado.size());
        assertEquals("Ana", resultado.get(0).getName());
        assertEquals("I", resultado.get(0).getDirection());
        assertEquals(100, resultado.get(0).getDistance());
    }

    @Test
    public void ramalDobleUnico() {
        String ramal = "2\n"
                + "Ana I 100\n"
                + "Pedro I 300\n";

        List<Ramal> resultado = ParseRamal.parseRamal(ramal);

        assertEquals(2, resultado.size());
        assertEquals("Ana", resultado.get(0).getName());
        assertEquals("Pedro", resultado.get(1).getName());
    }

    @Test
    public void ramalDobleMixto() {
        String ramal = "2\n"
                + "Ana I 100\n"
                + "Pedro D 300\n";

        List<Ramal> resultado = ParseRamal.parseRamal(ramal);

        assertEquals("Ana", resultado.get(0).getName());
        assertEquals("I", resultado.get(0).getDirection());
        assertEquals("Pedro", resultado.get(1).getName());
        assertEquals("D", resultado.get(1).getDirection());
    }

    @Test
    public void ramalMismaDistancia() {
        String ramal = "2\n"
                + "Ana I 300\n"
                + "Pedro D 300\n";

        List<Ramal> resultado = ParseRamal.parseRamal(ramal);

        assertEquals(300, resultado.get(0).getDistance());
        assertEquals(300, resultado.get(1).getDistance());
    }

    @Test
    public void ramalNormal() {
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
