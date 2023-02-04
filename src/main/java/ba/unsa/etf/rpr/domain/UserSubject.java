package ba.unsa.etf.rpr.domain;

public class UserSubject implements Idable{
    private String naziv;
    private String username;

    public UserSubject() { }

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

    // sta cu s ovim jer nemam id-a
    @Override
    public void setId(Integer id) {

    }

    @Override
    public int getId() {
        return 0;
    }

}
