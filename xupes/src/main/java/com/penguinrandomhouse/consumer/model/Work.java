package com.penguinrandomhouse.consumer.model;

/**
 *
 * POJO representing Work data (http://www.penguinrandomhouse.biz/webservices/rest/#response-work).
 * For POC, not all fields are mapped. Hence, the remaining fields are ignored.
 *
 * @author Karar
 * @since 2020-01-20
 */
public class Work {

    /** List of contributors formatted for display. */
    private String authorweb;

    /** The title of the book in proper case with leading articles. */
    private String titleweb;

    // TODO add more fields as needed

    /** Default constructor. */
    public Work() {
    }

    /*
     * Standard getter and setter methods.
     */

    public String getAuthorweb() {
        return authorweb;
    }

    public void setAuthorweb(String authorweb) {
        this.authorweb = authorweb;
    }

    public String getTitleweb() {
        return titleweb;
    }

    public void setTitleweb(String titleweb) {
        this.titleweb = titleweb;
    }
}
