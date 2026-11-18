public class Main {
    public static void main(String[] args) {
        Luzes luzes = new Luzes();
        Projetor projetor = new Projetor();
        Amplificador amplificador = new Amplificador();

        HomeTheaterFacade homeTheater = new HomeTheaterFacade(luzes, projetor, amplificador);

        homeTheater.assistirFilme("Interestelar");
        System.out.println();
        homeTheater.encerrarFilme();
    }
}
