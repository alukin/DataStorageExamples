/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.cn.al.teach.daexmpl.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author al
 */
@Entity
@Table(name = "book_examplar", catalog = "app2", schema = "public")
@NamedQueries({
    @NamedQuery(name = "BookExamplar.findAll", query = "SELECT b FROM BookExamplar b"),
    @NamedQuery(name = "BookExamplar.findByBeId", query = "SELECT b FROM BookExamplar b WHERE b.beId = :beId"),
    @NamedQuery(name = "BookExamplar.findByLoanId", query = "SELECT b FROM BookExamplar b WHERE b.loanId = :loanId"),
    @NamedQuery(name = "BookExamplar.findByPublishing", query = "SELECT b FROM BookExamplar b WHERE b.publishing = :publishing"),
    @NamedQuery(name = "BookExamplar.findByPublisher", query = "SELECT b FROM BookExamplar b WHERE b.publisher = :publisher"),
    @NamedQuery(name = "BookExamplar.findByDescription", query = "SELECT b FROM BookExamplar b WHERE b.description = :description")})
public class BookExamplar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "be_id")
    private Long beId;
    @Column(name = "loan_id")
    private BigInteger loanId;
    @Column(name = "publishing")
    @Temporal(TemporalType.DATE)
    private Date publishing;
    @Column(name = "publisher")
    private String publisher;
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "book_id", referencedColumnName = "book_id")
    @ManyToOne(optional = false)
    private Book bookId;

    public BookExamplar() {
    }

    public BookExamplar(Long beId) {
        this.beId = beId;
    }

    public Long getBeId() {
        return beId;
    }

    public void setBeId(Long beId) {
        this.beId = beId;
    }

    public BigInteger getLoanId() {
        return loanId;
    }

    public void setLoanId(BigInteger loanId) {
        this.loanId = loanId;
    }

    public Date getPublishing() {
        return publishing;
    }

    public void setPublishing(Date publishing) {
        this.publishing = publishing;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Book getBookId() {
        return bookId;
    }

    public void setBookId(Book bookId) {
        this.bookId = bookId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (beId != null ? beId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BookExamplar)) {
            return false;
        }
        BookExamplar other = (BookExamplar) object;
        if ((this.beId == null && other.beId != null) || (this.beId != null && !this.beId.equals(other.beId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.cn.al.teach.jpaexample.model.BookExamplar[ beId=" + beId + " ]";
    }
    
}
