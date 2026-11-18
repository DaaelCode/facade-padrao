public class Amplificador {
    private boolean ligado = false;
    private int volume = 0;

    public void ligar() {
        ligado = true;
        System.out.println("Amplificador ligado");
    }

    public void desligar() {
        ligado = false;
        volume = 0;
        System.out.println("Amplificador desligado");
    }

    public void ajustarVolume(int volume) {
        this.volume = volume;
        System.out.println("Volume em " + volume);
    }

    public boolean isLigado() {
        return ligado;
    }

    public int getVolume() {
        return volume;
    }
}
