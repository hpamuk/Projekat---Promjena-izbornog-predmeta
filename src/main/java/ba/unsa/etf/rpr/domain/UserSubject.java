package ba.unsa.etf.rpr.domain;

/**
 * Bean for User subject
 *  @author Hena Pamuk
 */
public class UserSubject implements Idable{
    private Integer id;
    private String naziv;
    private String username;

    /**
     * Instantiates a new User subject.
     */
    public UserSubject() {
    }

    /**
     * Instantiates a new User subject.
     *
     * @param naziv    the naziv
     * @param username the username
     */
    public UserSubject(String naziv, String username) {
        this.id = id;
        this.naziv = naziv;
        this.username = username;
    }

    /**
     * Gets naziv.
     *
     * @return the naziv
     */
    public String getNaziv() {
        return naziv;
    }

    /**
     * Sets naziv.
     *
     * @param naziv the naziv
     */
    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    /**
     * Gets username.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets username.
     *
     * @param username the username
     */
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
