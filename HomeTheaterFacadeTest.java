import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HomeTheaterFacadeTest {
    private PrintStream saidaOriginal;
    private ByteArrayOutputStream capturada;
    private Luzes luzes;
    private Projetor projetor;
    private Amplificador amplificador;
    private HomeTheaterFacade homeTheater;

    @Before
    public void preparar() {
        saidaOriginal = System.out;
        capturada = new ByteArrayOutputStream();
        System.setOut(new PrintStream(capturada, true, StandardCharsets.UTF_8));

        luzes = new Luzes();
        projetor = new Projetor();
        amplificador = new Amplificador();
        homeTheater = new HomeTheaterFacade(luzes, projetor, amplificador);
    }

    @After
    public void restaurarSaida() {
        System.setOut(saidaOriginal);
    }

    private String saida() {
        return capturada.toString(StandardCharsets.UTF_8);
    }

    @Test
    public void estadoInicialAntesDeAssistir() {
        assertTrue(luzes.isAcesas());
        assertFalse(projetor.isLigado());
        assertFalse(amplificador.isLigado());
    }

    @Test
    public void assistirFilmeApagaAsLuzes() {
        homeTheater.assistirFilme("Matrix");
        assertFalse(luzes.isAcesas());
    }

    @Test
    public void assistirFilmeLigaProjetorEAmplificador() {
        homeTheater.assistirFilme("Matrix");
        assertTrue(projetor.isLigado());
        assertTrue(amplificador.isLigado());
    }

    @Test
    public void assistirFilmeAjustaOVolume() {
        homeTheater.assistirFilme("Matrix");
        assertEquals(10, amplificador.getVolume());
    }

    @Test
    public void assistirFilmeMostraONomeDoFilme() {
        homeTheater.assistirFilme("Matrix");
        assertTrue(saida().contains("Reproduzindo: Matrix"));
    }

    @Test
    public void encerrarFilmeDesligaTudoEAcendeAsLuzes() {
        homeTheater.assistirFilme("Matrix");
        homeTheater.encerrarFilme();

        assertTrue(luzes.isAcesas());
        assertFalse(projetor.isLigado());
        assertFalse(amplificador.isLigado());
        assertEquals(0, amplificador.getVolume());
    }

    @Test
    public void assistirFilmeExecutaOsPassosNaOrdemCerta() {
        homeTheater.assistirFilme("Matrix");
        String saida = saida();

        int luzesApagadas = saida.indexOf("Luzes apagadas");
        int projetorLigado = saida.indexOf("Projetor ligado");
        int amplificadorLigado = saida.indexOf("Amplificador ligado");
        int reproduzindo = saida.indexOf("Reproduzindo");

        assertTrue(luzesApagadas < projetorLigado);
        assertTrue(projetorLigado < amplificadorLigado);
        assertTrue(amplificadorLigado < reproduzindo);
    }
}
