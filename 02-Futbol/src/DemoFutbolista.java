public class DemoFutbolista {
    public static void main(String[] args) throws InterruptedException{
        String[] noms = {"Piqué", "Vinicius", "Torres", "Ramos", "Ronaldo",
                        "Lewan", "Belli", "Arnau", "Aspas", "Messi", "MBapé"};

        Futbolista[] jugadors = new Futbolista[Futbolista.NUM_JUGADORS];

        //creem fils
        for (int i = 0; i < jugadors.length; i++) {
            jugadors[i] = new Futbolista(noms[i]);
        }

        //iniciem fils
        System.out.println("Inici dels xuts -----------------");
        for(Futbolista f : jugadors){
            f.start();
        }
        //esperem a tots
        for(Futbolista f: jugadors){
            f.join();
        }
        System.out.println("Fi dels xuts ---------------------");

        //estadistiques
        System.out.println("---- Estadístiques ----------");
        for(Futbolista f : jugadors){
            System.out.printf("%-10s -> %d gols%n", f.getName(), f.getNgols());
        }

    }
}
