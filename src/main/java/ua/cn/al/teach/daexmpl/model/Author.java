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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author al
 */
@Entity
@Table(name = "author", catalog = "app2", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Author.findAll", query = "SELECT a FROM Author a"),
    @NamedQuery(name = "Author.findByAuthorId", query = "SELECT a FROM Author a WHERE a.authorId = :authorId"),
    @NamedQuery(name = "Author.findByName", query = "SELECT a FROM Author a WHERE a.name = :name"),
    @NamedQuery(name = "Author.findByInfo", query = "SELECT a FROM Author a WHERE a.info = :info")})
public class Author implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "author_id")
    private Long authorId;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Column(name = "info")
    private String info;
    @JoinTable(name = "book_author", joinColumns = {
        @JoinColumn(name = "author_id", referencedColumnName = "author_id")}, inverseJoinColumns = {
        @JoinColumn(name = "book_id", referencedColumnName = "book_id")})
    @ManyToMany
    private Set<Book> bookSet=new HashSet<>();

    public Author() {
    }

    public Author(Long authorId) {
        this.authorId = authorId;
    }

    public Author(Long authorId, String name) {
        this.authorId = authorId;
        this.name = name;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Set<Book> getBookSet() {
        return bookSet;
    }

    public void setBookSet(Set<Book> bookSet) {
        this.bookSet = bookSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (authorId != null ? authorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Author)) {
            return false;
        }
        Author other = (Author) object;
        if ((this.authorId == null && other.authorId != null) || (this.authorId != null && !this.authorId.equals(other.authorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.cn.al.teach.jpaexample.model.Author[ authorId=" + authorId + " ]";
    }
    
}
