package ba.unsa.etf.rpr.domain;

import java.io.Serializable;
import java.util.Objects;

/**
 * Bean for User subject
 *  @author Hena Pamuk
 */
public class UserSubject implements Idable, Serializable {
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
     * @param id       the id
     * @param naziv    the naziv
     * @param username the username
     */
    public UserSubject(Integer id, String naziv, String username) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserSubject that = (UserSubject) o;
        return Objects.equals(id, that.id) && Objects.equals(naziv, that.naziv) && Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, naziv, username);
    }

    @Override
    public String toString() {
        return "UserSubject{" +
                "id=" + id +
                ", naziv='" + naziv + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
