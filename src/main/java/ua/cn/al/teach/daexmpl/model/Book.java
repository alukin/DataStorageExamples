/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.cn.al.teach.daexmpl.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author al
 */
@Entity
@Table(name = "book", catalog = "app2", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Book.findAll", query = "SELECT b FROM Book b"),
    @NamedQuery(name = "Book.findByBookId", query = "SELECT b FROM Book b WHERE b.bookId = :bookId"),
    @NamedQuery(name = "Book.findByTitle", query = "SELECT b FROM Book b WHERE b.title = :title"),
    @NamedQuery(name = "Book.findByInfo", query = "SELECT b FROM Book b WHERE b.info = :info"),
    @NamedQuery(name = "Book.findByDescription", query = "SELECT b FROM Book b WHERE b.description = :description")})
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "book_id")
    private Long bookId;
    @Basic(optional = false)
    @Column(name = "title")
    private String title;
    @Column(name = "info")
    private String info;
    @Column(name = "description")
    private String description;
    @ManyToMany(mappedBy = "bookSet")
    private Set<Author> authorSet=new HashSet<>();
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bookId")
    private Set<BookExamplar> bookExamplarSet = new HashSet<>();

    public Book() {
    }

    public Book(Long bookId) {
        this.bookId = bookId;
    }

    public Book(Long bookId, String title) {
        this.bookId = bookId;
        this.title = title;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Author> getAuthorSet() {
        return authorSet;
    }

    public void setAuthorSet(Set<Author> authorSet) {
        this.authorSet = authorSet;
    }

    public Set<BookExamplar> getBookExamplarSet() {
        return bookExamplarSet;
    }

    public void setBookExamplarSet(Set<BookExamplar> bookExamplarSet) {
        this.bookExamplarSet = bookExamplarSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bookId != null ? bookId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Book)) {
            return false;
        }
        Book other = (Book) object;
        if ((this.bookId == null && other.bookId != null) || (this.bookId != null && !this.bookId.equals(other.bookId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.cn.al.teach.jpaexample.model.Book[ bookId=" + bookId + " ]";
    }
    
}
