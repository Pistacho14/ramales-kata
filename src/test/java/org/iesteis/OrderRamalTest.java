package org.iesteis;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;


public class OrderRamalTest 
{
    
    @Test
    public void ramalUnico()
    {        
        String ramal = "1\n" + //
                    "Ana I 100\n";

        String orderedRamal = "Ana\n" + //
                        "---";

        assertEquals(orderedRamal ,ramal);
    }

    @Test
    public void ramalDobleUnico()
    {        
        String ramal = "2\n" + //
                    "Ana I 100\n" + //
                    "Pedro I 300\n";

        String orderedRamal = "Ana\n" + //
                        "Pedro\n" + //
                        "---";

        assertEquals(orderedRamal ,ramal);
    }

    @Test
    public void ramalDobleMixto()
    {        
        String ramal = "2\n" + //
                    "Ana I 100\n" + //
                    "Pedro D 300\n";

        String orderedRamal = "Ana\n" + //
                        "Pedro\n" + //
                        "---";

        assertEquals(orderedRamal ,ramal);
    }

    @Test
    public void ramalMismaDistancia()
    {        
        String ramal = "2\n" + //
                    "Ana I 300\n" + //
                    "Pedro D 300\n";

        String orderedRamal = "Ana\n" + //
                        "Pedro\n" + //
                        "---";

        assertEquals(orderedRamal ,ramal);
    }

    @Test
    public void ramalNormal()
    {        
        String ramal = "5\n" + //
                    "Ana I 100\n" + //
                    "Pedro D 300\n" + //
                    "Luis I 200\n" + //
                    "Maria D 100\n" + //
                    "Carlos I 300";

        String orderedRamal = "Ana\n" + //
                        "Maria\n" + //
                        "Luis\n" + //
                        "Carlos\n" + //
                        "Pedro\n" + //
                        "---";

        assertEquals(orderedRamal ,ramal);
    }
}
