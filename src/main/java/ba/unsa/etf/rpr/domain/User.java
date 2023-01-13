package ba.unsa.etf.rpr.domain;

public class User implements Idable {
    private int id;
    private String imeIPrezime;
    private int brIndeksa;

    public User() {
        this.id = 0;
        this.imeIPrezime = null;
        this.brIndeksa = 0;
    }

    public User(int id, String imeIPrezime, int brIndeksa) {
        this.id = id;
        this.imeIPrezime = imeIPrezime;
        this.brIndeksa = brIndeksa;
    }

    public String getImeIPrezime() {
        return imeIPrezime;
    }

    public void setImeIPrezime(String imeIPrezime) {
        this.imeIPrezime = imeIPrezime;
    }

    public int getBrIndeksa() {
        return brIndeksa;
    }

    public void setBrIndeksa(int brIndeksa) {
        this.brIndeksa = brIndeksa;
    }

    @Override
    public void setId(int id) {

    }

    @Override
    public int getId() {
        return id;
    }
}
