public class Projetor {
    private boolean ligado = false;

    public void ligar() {
        ligado = true;
        System.out.println("Projetor ligado");
    }

    public void desligar() {
        ligado = false;
        System.out.println("Projetor desligado");
    }

    public boolean isLigado() {
        return ligado;
    }
}
