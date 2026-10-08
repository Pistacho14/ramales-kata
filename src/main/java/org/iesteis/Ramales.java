package org.iesteis;

import java.util.List;

public class Ramales 
{
    public static void main( String[] args )
    {
        List<String> lines = args[0].lines().toList();
        StringBuilder cleanRamales = new StringBuilder();
        int lineIndex = 0;

        while (lineIndex < lines.size()) {
            int ramalCount = Integer.parseInt(lines.get(lineIndex));
            lineIndex += 1;

            if (ramalCount == 0) {
                break;
            }

            StringBuilder ramalGroup = new StringBuilder()
                    .append(ramalCount)
                    .append("\n");

            for (int i = 0; i < ramalCount; i++) {
                ramalGroup.append(lines.get(lineIndex))
                        .append("\n");
                lineIndex += 1;
            }

            List<Ramal> sanitizedRamales = SortRamal.sortRamal(
                    ParseRamal.parseRamal(ramalGroup.toString()));

            for (var ramal : sanitizedRamales) {
                cleanRamales.append(ramal.toString())
                        .append("\n");
            }

            cleanRamales.append("---")
                    .append("\n");
        }

        System.out.println(cleanRamales.toString());
    }
}
