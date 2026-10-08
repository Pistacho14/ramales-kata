package org.iesteis;

import java.util.Comparator;
import java.util.List;

public class SortRamal {

    public static List<Ramal> sortRamal(List<Ramal> ramalList) {

        Comparator<Ramal> byDirection = Comparator.comparingInt(ramal ->
                ramal.getDirection().equals("I") ? 0 : 1);

        return ramalList.stream()
                .sorted(Comparator.comparing(Ramal::getDistance)
                        .thenComparing(byDirection))
                .toList();
    }
}
