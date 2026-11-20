import java.util.Random;

public class Motor extends Thread{
    
    private int potenciaObjectiu = 0;
    private int potenciaActual = 0;
    private boolean ordrePendent = false;

    private final Random random = new Random();

    public Motor(String nom){
        super(nom);
    }

    public synchronized void setPotencia(int p){
        potenciaObjectiu = p;
        ordrePendent = true;
    }

    private synchronized int getPotenciaObjectiu(){
        return potenciaObjectiu;
    }

    private synchronized boolean confirmaArribada(){
        if(potenciaActual == potenciaObjectiu && ordrePendent){
            ordrePendent = false;
            return true;
        }
        return false;
    }

    @Override 
    public void run(){
        boolean sortir = false;

        while(!sortir){
            int objectiu = getPotenciaObjectiu();

            if(potenciaActual != objectiu){
                try {
                    Thread.sleep(1000 + random.nextInt(1001));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }

                objectiu = getPotenciaObjectiu();
                String accio;

                if (potenciaActual < objectiu) {
                    potenciaActual++;
                    accio = "Incre.";
                } else if (potenciaActual > objectiu) {
                    potenciaActual--;
                    accio = "Decre.";
                } else {
                    continue;
                }
                System.out.println(getName() + ": " + accio + "Objectiu: " + objectiu + " Actual: " + potenciaActual);
            }else if(confirmaArribada()){
                System.out.println(getName() + ": FerRes Objectiu: " + potenciaActual + " Actual: " + potenciaActual);
                if(potenciaActual == 0){
                    sortir = true;
                }
            }else{
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        }
    }

}
