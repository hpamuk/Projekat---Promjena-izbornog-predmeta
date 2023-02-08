package ba.unsa.etf.rpr.domain;

import java.util.Objects;

/**
 * Bean for New subject
 *  @author Hena Pamuk
 */
public class NewSubject implements Idable{
    private Integer id;
    private String naziv;
    private String profesor;
    private Integer brCasovaSemestralno;
    private Integer brCasovaSedmicno;

    /**
     * Instantiates a new New subject.
     */
    public NewSubject() {
    }

    /**
     * Instantiates a new New subject.
     *
     * @param id                  the id
     * @param naziv               the naziv
     * @param nazivProfesora      the naziv profesora
     * @param brCasovaSemestralno the br casova semestralno
     * @param brCasovaSedmicno    the br casova sedmicno
     */
    public NewSubject(Integer id, String naziv, String nazivProfesora, Integer brCasovaSemestralno, Integer brCasovaSedmicno) {
        this.id = id;
        this.naziv = naziv;
        this.profesor = nazivProfesora;
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
     * @param nazivProfesora the naziv profesora
     */
    public void setProfesor(String nazivProfesora) {
        this.profesor = nazivProfesora;
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
        NewSubject that = (NewSubject) o;
        return id == that.id && brCasovaSemestralno == that.brCasovaSemestralno && brCasovaSedmicno == that.brCasovaSedmicno
                && Objects.equals(naziv, that.naziv) && Objects.equals(profesor, that.profesor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, naziv, profesor, brCasovaSemestralno, brCasovaSedmicno);
    }

    @Override
    public String toString() {
        return "NewSubject{" +
                "id=" + id +
                ", naziv='" + naziv + '\'' +
                ", nazivProfesora='" + profesor + '\'' +
                ", brCasovaSemestralno=" + brCasovaSemestralno +
                ", brCasovaSedmicno=" + brCasovaSedmicno +
                '}';
    }

}
