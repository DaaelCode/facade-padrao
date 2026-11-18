public class Luzes {
    private boolean acesas = true;

    public void apagar() {
        acesas = false;
        System.out.println("Luzes apagadas");
    }

    public void acender() {
        acesas = true;
        System.out.println("Luzes acesas");
    }

    public boolean isAcesas() {
        return acesas;
    }
}
