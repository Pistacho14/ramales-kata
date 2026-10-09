package org.iesteis;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

class SortRamalTest {

    @Test
    void emptyList() {
        List<Ramal> resultado = SortRamal.sortRamal(List.of());

        assertEquals(List.of(), resultado);
    }

    @Test
    void soloRamal() {
        Ramal ramal = new Ramal("Ana I 100");

        List<Ramal> resultado = SortRamal.sortRamal(List.of(ramal));

        assertEquals(List.of(ramal), resultado);
    }

    @Test
    void ascendantRamalOrder() {
        Ramal ramalLejano = new Ramal("Pedro D 300");
        Ramal ramalCercano = new Ramal("Ana I 100");
        Ramal ramalIntermedio = new Ramal("Luis I 200");

        List<Ramal> resultado = SortRamal.sortRamal(
                List.of(ramalLejano, ramalCercano, ramalIntermedio));

        assertEquals(List.of(ramalCercano, ramalIntermedio, ramalLejano), resultado);
    }

    @Test
    void directionOrder() {
        Ramal primero = new Ramal("Ana I 100");
        Ramal segundo = new Ramal("Maria D 100");

        List<Ramal> resultado = SortRamal.sortRamal(List.of(segundo, primero));

        assertEquals(List.of(primero, segundo), resultado);
    }
}
