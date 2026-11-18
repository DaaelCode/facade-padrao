import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SubsistemasTest {
    private PrintStream saidaOriginal;

    @Before
    public void silenciarSaida() {
        saidaOriginal = System.out;
        System.setOut(new PrintStream(new ByteArrayOutputStream()));
    }

    @After
    public void restaurarSaida() {
        System.setOut(saidaOriginal);
    }

    @Test
    public void luzesApagamEAcendem() {
        Luzes luzes = new Luzes();
        assertTrue(luzes.isAcesas());

        luzes.apagar();
        assertFalse(luzes.isAcesas());

        luzes.acender();
        assertTrue(luzes.isAcesas());
    }

    @Test
    public void projetorLigaEDesliga() {
        Projetor projetor = new Projetor();
        assertFalse(projetor.isLigado());

        projetor.ligar();
        assertTrue(projetor.isLigado());

        projetor.desligar();
        assertFalse(projetor.isLigado());
    }

    @Test
    public void amplificadorAjustaVolumeEZeraAoDesligar() {
        Amplificador amplificador = new Amplificador();
        amplificador.ligar();
        amplificador.ajustarVolume(7);
        assertEquals(7, amplificador.getVolume());

        amplificador.desligar();
        assertFalse(amplificador.isLigado());
        assertEquals(0, amplificador.getVolume());
    }
}
