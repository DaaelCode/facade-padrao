public class HomeTheaterFacade {
    private final Luzes luzes;
    private final Projetor projetor;
    private final Amplificador amplificador;

    public HomeTheaterFacade(Luzes luzes, Projetor projetor, Amplificador amplificador) {
        this.luzes = luzes;
        this.projetor = projetor;
        this.amplificador = amplificador;
    }

    public void assistirFilme(String filme) {
        luzes.apagar();
        projetor.ligar();
        amplificador.ligar();
        amplificador.ajustarVolume(10);
        System.out.println("Reproduzindo: " + filme);
    }

    public void encerrarFilme() {
        System.out.println("Encerrando o filme");
        projetor.desligar();
        amplificador.desligar();
        luzes.acender();
    }
}
