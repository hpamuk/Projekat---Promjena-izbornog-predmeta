package ba.unsa.etf.rpr.domain;

public class User implements Idable {
    private Integer id;
    private String username;
    private String brIndeksa;

    public User() {
    }

    public User(Integer id, String imeIPrezime, String brIndeksa) {
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

    public String getBrIndeksa() {
        return brIndeksa;
    }

    public void setBrIndeksa(String brIndeksa) {
        this.brIndeksa = brIndeksa;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }

}
