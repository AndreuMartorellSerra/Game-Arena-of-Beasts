public class Lluitador {
    static final int WIZARD = 1;
    static final int OGRE = 2;
    static final int HIDRA = 3;
    static final int DEMON = 4;
    static final int DRAGON = 5;

    String nom;
    int nivell;
    int clase;
    int punts;
    int puntsDevida;
    int puntsDeVidaMaxima;
    int atac;
    int defensa;
    int atacOriginal;
    int defensaOriginal;
    int torn;
    int tornRecupera;

    // Constructor
    public Lluitador(String nom, int clase, int punts,int puntsDevida, int puntsDeVidaMaxima, int atac, int defensa){
        this.nom = nom;
        this.clase = clase;
        this.punts = punts;
        this.puntsDevida = puntsDevida;
        this.puntsDeVidaMaxima = puntsDeVidaMaxima;
        this.atac = atac;
        this.defensa = defensa;
        this.atacOriginal = atac;
        this.defensaOriginal = defensa;
        this.nivell = 1;
        this.torn =1;
    }

    void incTorn(){
        this.torn++;
        if(this.torn == this.tornRecupera){
            this.atac = this.atacOriginal;
            this.defensa = this.defensaOriginal;
        }
    }

    void penalitza(){
        // Divideix per 2 la cantidd d'atact o defensa de forma aleatoria nomes durant un torn
        if (Math.random()<0.5){
            this.defensa/=2;
        } else {
            this.atac/=2;
        }
        tornRecupera = this.torn + 2;
    }

    void restaPuntsDeVida(int punts){
        this.puntsDevida -= punts;
        if (this.puntsDevida < 0 ) this.puntsDevida = 0;
    }

    void recuperaVida(int punts){
        this.puntsDevida += punts;
        if (this.puntsDevida > this.puntsDeVidaMaxima ) this.puntsDevida = this.puntsDeVidaMaxima;
    }

    public int getPuntsDevida() {
        return puntsDevida;
    }

    public void setPuntsDevida(int puntsDevida) {
        this.puntsDevida = puntsDevida;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getClase() {
        return clase;
    }

    public void setClase(int clase) {
        this.clase = clase;
    }

    public int getPunts() {
        return punts;
    }

    public void setPunts(int punts) {
        this.punts = punts;
    }

    public int getPuntsDeVidaMaxima() {
        return puntsDeVidaMaxima;
    }

    public void setPuntsDeVidaMaxima(int puntsDeVidaMaxima) {
        this.puntsDeVidaMaxima = puntsDeVidaMaxima;
    }

    public int getAtac() {
        return atac;
    }

    public void setAtac(int atac) {
        this.atac = atac;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }
}
