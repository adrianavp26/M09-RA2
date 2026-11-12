public class Fil extends Thread {

    public Fil(String nom){
        super(nom);
    }

    @Override 
    public void run(){
        for (int i = 1; i <= 1000; i++) {
            if(i <= 9){
                System.out.println(getName() + " " + i);
            }
        }
        System.out.println("Acaba el fil " + getName());
    }
}
