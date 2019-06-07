/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.cn.al.teach.daexmpl.model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author al
 */
@Entity
@Table(name = "appuser", catalog = "app2", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Appuser.findAll", query = "SELECT a FROM Appuser a"),
    @NamedQuery(name = "Appuser.deleteAll", query = "DELETE FROM Appuser"),
    @NamedQuery(name = "Appuser.findByUserId", query = "SELECT a FROM Appuser a WHERE a.userId = :userId"),
    @NamedQuery(name = "Appuser.findByUsername", query = "SELECT a FROM Appuser a WHERE a.username = :username"),
    @NamedQuery(name = "Appuser.findByUsernameLike", query = "SELECT a FROM Appuser a WHERE a.username like :username"),
    @NamedQuery(name = "Appuser.findByCreatedBy", query = "SELECT a FROM Appuser a WHERE a.createdBy = :createdBy"),
    @NamedQuery(name = "Appuser.findByEmail", query = "SELECT a FROM Appuser a WHERE a.email = :email"),
    @NamedQuery(name = "Appuser.findByPasswdHash", query = "SELECT a FROM Appuser a WHERE a.passwdHash = :passwdHash"),
    @NamedQuery(name = "Appuser.findByLastLogin", query = "SELECT a FROM Appuser a WHERE a.lastLogin = :lastLogin")})
public class Appuser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "user_id")
    private Long userId;
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @Column(name = "created_by")
    private String createdBy;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "passwd_hash")
    private String passwdHash;
    @Column(name = "last_login")
    @Temporal(TemporalType.DATE)
    private Date lastLogin;
    @ManyToMany(mappedBy = "appuserSet")
    private Set<Ugroup> ugroupSet = new HashSet<>();
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "appuser")
    private Userdetails userdetails;

    public Appuser() {
    }

    public Appuser(Long userId) {
        this.userId = userId;
    }

    public Appuser(Long userId, String username, String createdBy, String email, String passwdHash) {
        this.userId = userId;
        this.username = username;
        this.createdBy = createdBy;
        this.email = email;
        this.passwdHash = passwdHash;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswdHash() {
        return passwdHash;
    }

    public void setPasswdHash(String passwdHash) {
        this.passwdHash = passwdHash;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Set<Ugroup> getUgroupSet() {
        return ugroupSet;
    }

    public void setUgroupSet(Set<Ugroup> ugroupSet) {
        this.ugroupSet = ugroupSet;
    }

    public Userdetails getUserdetails() {
        return userdetails;
    }

    public void setUserdetails(Userdetails userdetails) {
        this.userdetails = userdetails;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Appuser)) {
            return false;
        }
        Appuser other = (Appuser) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.cn.al.teach.jpaexample.model.Appuser[ userId=" + userId + " ]";
    }
    
}
