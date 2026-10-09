package org.iesteis;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

class RamalesTest {

    @Test
    void ramalUnico() {
        String entrada = "1\n"
                + "Ana I 100\n";

        assertEquals("Ana\n---", ejecutar(entrada));
    }

    @Test
    void ramalDobleUnico() {
        String entrada = "2\n"
                + "Ana I 100\n"
                + "Pedro I 300\n";

        assertEquals("Ana\nPedro\n---", ejecutar(entrada));
    }

    @Test
    void ramalDobleMixto() {
        String entrada = "2\n"
                + "Ana I 100\n"
                + "Pedro D 300\n";

        assertEquals("Ana\nPedro\n---", ejecutar(entrada));
    }

    @Test
    void ramalMismaDistancia() {
        String entrada = "2\n"
                + "Ana I 300\n"
                + "Pedro D 300\n";

        assertEquals("Ana\nPedro\n---", ejecutar(entrada));
    }

    @Test
    void ramalNormal() {
        String entrada = "5\n"
                + "Ana I 100\n"
                + "Pedro D 300\n"
                + "Luis I 200\n"
                + "Maria D 100\n"
                + "Carlos I 300";

        assertEquals("Ana\nMaria\nLuis\nCarlos\nPedro\n---", ejecutar(entrada));
    }

    @Test
    void variosConjuntosDeRamales() {
        String entrada = "3\n"
                + "EdwardPease D 250\n"
                + "GeorgeStephenson I 500\n"
                + "GeorgeDixon I 250\n"
                + "1\n"
                + "GeorgeOverton D 1000\n"
                + "0\n";

        assertEquals(
                "GeorgeDixon\n"
                        + "EdwardPease\n"
                        + "GeorgeStephenson\n"
                        + "---\n"
                        + "GeorgeOverton\n"
                        + "---",
                ejecutar(entrada));
    }

    private String ejecutar(String entrada) {
        ByteArrayOutputStream salida = new ByteArrayOutputStream();
        PrintStream salidaOriginal = System.out;

        try {
            System.setOut(new PrintStream(salida));
            Ramales.main(new String[] { entrada });
            return salida.toString().trim();
        } finally {
            System.setOut(salidaOriginal);
        }
    }
}
