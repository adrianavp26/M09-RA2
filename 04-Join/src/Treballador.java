import java.util.Random;

public class Treballador extends Thread{
    
    private int edat_inici_treball;
    private int edat_fi_treball;
    private int edat_actual;
    private float cobrat;
    private float sou_anual_brut;
    private Random rnd = new Random();

    private float mensual;

    public int getEdat_actual() {
        return edat_actual;
    }

    public float getCobrat() {
        return cobrat;
    }
    //constructor
    public Treballador( int edat_inici_treball, int edat_fi_treball, float sou_anual_brut, String nom ){

        super(nom);
        this.edat_inici_treball = edat_inici_treball;
        this.edat_fi_treball = edat_fi_treball;
        this.sou_anual_brut = sou_anual_brut;
        
        this.edat_actual = 0;
        this.cobrat = 0.0f;
    }

    public void cobra(){
        this.mensual = sou_anual_brut / 12;
        cobrat += mensual;
    }
    public void pagaImpostos(){
        
    }


}
