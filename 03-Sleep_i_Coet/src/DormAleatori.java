import java.util.Random;

public class DormAleatori extends Thread{

    private final long instantCreacio;
    private final Random random = new Random();

    public DormAleatori(String nom){
        super(nom);
        instantCreacio = System.currentTimeMillis();
    }

    @Override 
    public void run(){
        for (int i = 0; i < 10; i++) {
            int interval = random.nextInt(1000);
            long total = System.currentTimeMillis() - instantCreacio;

            System.out.printf("%-4s(%d) a dormir %4dms total %5dms%n", getName(), i, interval, total);

            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }

    public static void main(String[] args) {
        DormAleatori joan = new DormAleatori("Joan");
        DormAleatori pep = new DormAleatori("Pep");

        joan.start();
        pep.start();
        System.out.println("---------Fi del main--------------------");
    }
}
