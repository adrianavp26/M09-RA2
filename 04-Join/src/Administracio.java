public class Administracio {

    private int num_poblacio_activa = 50;
    private Treballador[] poblacio_activa;

    //constructor 
    public Administracio(){
        //crear el array
        this.poblacio_activa = new Treballador[num_poblacio_activa];
        for (int i = 0; i < num_poblacio_activa; i++) {
            poblacio_activa[i] = new Treballador(20, 65, 25000, "Ciutadà-" + i);
        }
    }
    public static void main(String[] args) throws InterruptedException{
        Administracio admin = new Administracio();

        for ( Treballador elemento : admin.poblacio_activa) {
            elemento.start();
        }
        for(Treballador element : admin.poblacio_activa){
            element.join();
        }

        for(Treballador element : admin.poblacio_activa){
            System.out.printf("%s -> edat: %d / total: %.2f%n", element.getName(), element.getEdat_actual(), element.getCobrat());
        }
    }
}
