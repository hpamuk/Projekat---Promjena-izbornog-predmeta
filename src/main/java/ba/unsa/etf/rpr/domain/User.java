package ba.unsa.etf.rpr.domain;

import java.io.Serializable;
import java.util.Objects;

/**
 * Bean for User
 *
 * @author Hena Pamuk
 */
public class User implements Idable, Serializable {
    private Integer id;
    private String username;
    private String brIndeksa;

    /**
     * Instantiates a new User.
     */
    public User() {
    }

    /**
     * Instantiates a new User.
     *
     * @param id          the id
     * @param imeIPrezime the ime i prezime
     * @param brIndeksa   the br indeksa
     */
    public User(Integer id, String imeIPrezime, String brIndeksa) {
        this.id = id;
        this.username = imeIPrezime;
        this.brIndeksa = brIndeksa;
    }

    /**
     * Gets ime i prezime.
     *
     * @return the ime i prezime
     */
    public String getImeIPrezime() {
        return username;
    }

    /**
     * Sets ime i prezime.
     *
     * @param username the username
     */
    public void setImeIPrezime(String username) {
        this.username = username;
    }

    /**
     * Gets br indeksa.
     *
     * @return the br indeksa
     */
    public String getBrIndeksa() {
        return brIndeksa;
    }

    /**
     * Sets br indeksa.
     *
     * @param brIndeksa the br indeksa
     */
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(username, user.username) && Objects.equals(brIndeksa, user.brIndeksa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, brIndeksa);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", brIndeksa='" + brIndeksa + '\'' +
                '}';
    }
}
