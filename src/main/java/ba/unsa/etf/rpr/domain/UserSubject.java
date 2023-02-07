package ba.unsa.etf.rpr.domain;

public class UserSubject implements Idable{
    private Integer id;
    private String naziv;
    private String username;

    public UserSubject() {
    }

    public UserSubject(String naziv, String username) {
        this.naziv = naziv;
        this.username = username;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
