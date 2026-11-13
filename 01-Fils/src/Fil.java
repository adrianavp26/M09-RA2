public class Fil extends Thread {

    private final long delay;

    public Fil(String nom){
        this(nom, 0);
    }

    public Fil(String nom, long delay){
        super(nom);
        this.delay = delay;
    }

    @Override 
    public void run(){
        if(delay > 0){
            for (int i = 1; i <= 9; i++) {
                System.out.println(getName() + " " + i);
                try {
                    Thread.sleep(delay);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        }else{
            for (int i = 1; i <= 1000; i++) {
                if(i <= 9){
                    System.out.println(getName() + " " + i);
                }
            }
        }
        System.out.println("Acaba el fil " + getName());
    }
}
