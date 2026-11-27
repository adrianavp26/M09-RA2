public class Compte {
    private float saldo;
    private static Compte cp = null;
    //constructor
    private Compte(){

    }

    //getter i setter
    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
    
    public static synchronized Compte getInstance(){
        if(cp == null){
            cp = new Compte();
        }
        return cp;
    }
}
