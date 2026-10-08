package org.iesteis;

import java.util.List;

public final class ParseRamal {

    private ParseRamal() {
    }

    public static List<Ramal> parseRamal(String ramal) {

        return ramal.lines()
                .filter(x -> x.length() > 1)
                .map(Ramal::new)
                .toList();
    }
}
