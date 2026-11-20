import java.util.Scanner;

public class Coet {
    private static final int NUM_MOTORS = 4;
    private final Motor[] motors = new Motor[NUM_MOTORS];

    public Coet(){
        for (int i = 0; i < NUM_MOTORS; i++) {
            motors[i] = new Motor("Motor " + i);
        }
    }

    public void passaAPotencia(int p){
        if(p < 0 || p > 10){
            throw new IllegalArgumentException("Potència incorrecta (ha d'estar entre 0 i 10): " + p);

        }
        System.out.println("Passat a potencia " + p);
        for(Motor m : motors){
            m.setPotencia(p);
        }
    }

    public void arranca(){
        for(Motor m : motors){
            m.start();
        }
        Scanner sc = new Scanner(System.in);
        int p = -1;

        while(p != 0){
            p = sc.nextInt();
            try{
                passaAPotencia(p);
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }

        //esperem als motors 
        for(Motor m : motors){
            try {
                m.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) {
        new Coet().arranca();;
    }
}
