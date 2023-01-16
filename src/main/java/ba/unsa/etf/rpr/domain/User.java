package ba.unsa.etf.rpr.domain;

public class User implements Idable {
    private int id;
    private String username;
    private int brIndeksa;

    public User() {
        this.id = 0;
        this.username = null;
        this.brIndeksa = 0;
    }

    public User(int id, String imeIPrezime, int brIndeksa) {
        this.id = id;
        this.username = imeIPrezime;
        this.brIndeksa = brIndeksa;
    }

    public String getImeIPrezime() {
        return username;
    }

    public void setImeIPrezime(String username) {
        this.username = username;
    }

    public int getBrIndeksa() {
        return brIndeksa;
    }

    public void setBrIndeksa(int brIndeksa) {
        this.brIndeksa = brIndeksa;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }
}
