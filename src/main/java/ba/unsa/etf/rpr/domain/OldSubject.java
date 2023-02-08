package ba.unsa.etf.rpr.domain;

import java.util.Objects;

/**
 * Bean for Old subject
 *  @author Hena Pamuk
 */
public class OldSubject implements Idable{
    private Integer id;
    private String naziv;
    private String profesor;
    private Integer brCasovaSemestralno;
    private Integer brCasovaSedmicno;

    /**
     * Instantiates a new Old subject.
     */
    public OldSubject() {
    }

    /**
     * Instantiates a new Old subject.
     *
     * @param id                  the id
     * @param naziv               the naziv
     * @param profesor            the profesor
     * @param brCasovaSemestralno the br casova semestralno
     * @param brCasovaSedmicno    the br casova sedmicno
     */
    public OldSubject(Integer id, String naziv, String profesor, Integer brCasovaSemestralno, Integer brCasovaSedmicno) {
        this.id = id;
        this.naziv = naziv;
        this.profesor = profesor;
        this.brCasovaSemestralno = brCasovaSemestralno;
        this.brCasovaSedmicno = brCasovaSedmicno;
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
     * Gets profesor.
     *
     * @return the profesor
     */
    public String getProfesor() {
        return profesor;
    }

    /**
     * Sets profesor.
     *
     * @param profesor the profesor
     */
    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    /**
     * Gets br casova semestralno.
     *
     * @return the br casova semestralno
     */
    public int getBrCasovaSemestralno() {
        return brCasovaSemestralno;
    }

    /**
     * Sets br casova semestralno.
     *
     * @param brCasovaSemestralno the br casova semestralno
     */
    public void setBrCasovaSemestralno(Integer brCasovaSemestralno) {
        this.brCasovaSemestralno = brCasovaSemestralno;
    }

    /**
     * Gets br casova sedmicno.
     *
     * @return the br casova sedmicno
     */
    public int getBrCasovaSedmicno() {
        return brCasovaSedmicno;
    }

    /**
     * Sets br casova sedmicno.
     *
     * @param brCasovaSedmicno the br casova sedmicno
     */
    public void setBrCasovaSedmicno(Integer brCasovaSedmicno) {
        this.brCasovaSedmicno = brCasovaSedmicno;
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
        OldSubject that = (OldSubject) o;
        return id == that.id && brCasovaSemestralno == that.brCasovaSemestralno && brCasovaSedmicno == that.brCasovaSedmicno && Objects.equals(naziv, that.naziv) && Objects.equals(profesor, that.profesor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, naziv, profesor, brCasovaSemestralno, brCasovaSedmicno);
    }

    @Override
    public String toString() {
        return naziv;
    }

}
