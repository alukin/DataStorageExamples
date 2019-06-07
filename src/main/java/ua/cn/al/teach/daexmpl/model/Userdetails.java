/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.cn.al.teach.daexmpl.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author al
 */
@Entity
@Table(name = "userdetails", catalog = "app2", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Userdetails.findAll", query = "SELECT u FROM Userdetails u"),
    @NamedQuery(name = "Userdetails.deleteAll", query = "DELETE FROM Userdetails"),
    @NamedQuery(name = "Userdetails.findByUserId", query = "SELECT u FROM Userdetails u WHERE u.userId = :userId"),
    @NamedQuery(name = "Userdetails.findByAddress", query = "SELECT u FROM Userdetails u WHERE u.address = :address"),
    @NamedQuery(name = "Userdetails.findByPhone", query = "SELECT u FROM Userdetails u WHERE u.phone = :phone"),
    @NamedQuery(name = "Userdetails.findByFirstName", query = "SELECT u FROM Userdetails u WHERE u.firstName = :firstName"),
    @NamedQuery(name = "Userdetails.findByLastName", query = "SELECT u FROM Userdetails u WHERE u.lastName = :lastName"),
    @NamedQuery(name = "Userdetails.findBySex", query = "SELECT u FROM Userdetails u WHERE u.sex = :sex"),
    @NamedQuery(name = "Userdetails.findByMobile", query = "SELECT u FROM Userdetails u WHERE u.mobile = :mobile"),
    @NamedQuery(name = "Userdetails.findByNotes", query = "SELECT u FROM Userdetails u WHERE u.notes = :notes")})
public class Userdetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "address")
    private String address;
    @Column(name = "phone")
    private String phone;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "sex")
    private String sex;
    @Column(name = "mobile")
    private String mobile;
    @Column(name = "notes")
    private String notes;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Appuser appuser;

    public Userdetails() {
    }

    public Userdetails(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Appuser getAppuser() {
        return appuser;
    }

    public void setAppuser(Appuser appuser) {
        this.appuser = appuser;
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
        if (!(object instanceof Userdetails)) {
            return false;
        }
        Userdetails other = (Userdetails) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.cn.al.teach.jpaexample.model.Userdetails[ userId=" + userId + " ]";
    }
    
}
