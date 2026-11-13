public class PrincipalEstricte {
    public static void main(String[] args) {
        Fil juan = new Fil("Juan", 1);
        Fil pepe = new Fil("Pepe", 1);

        juan.start();
        pepe.start();

        System.out.println("Termina thread main");
    }
}
