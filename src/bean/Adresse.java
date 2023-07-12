package bean;

public class Adresse {

    private final int id;
    private final String adresse, port, db;
    private final boolean primaire;

    public Adresse(int id, String adresse, String port, String db, boolean primaire) {
        this.id = id;
        this.adresse = adresse;
        this.port = port;
        this.db = db;
        this.primaire = primaire;
    }

    public int getId() {
        return id;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getPort() {
        return port;
    }

    public String getDb() {
        return db;
    }

    public boolean isPrimaire() {
        return primaire;
    }

}
