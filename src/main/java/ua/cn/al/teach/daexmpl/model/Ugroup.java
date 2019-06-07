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
@Table(name = "ugroup", catalog = "app2", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Ugroup.findAll", query = "SELECT u FROM Ugroup u"),
    @NamedQuery(name = "Ugroup.deleteAll", query = "DELETE FROM Ugroup"),
    @NamedQuery(name = "Ugroup.findByGroupId", query = "SELECT u FROM Ugroup u WHERE u.groupId = :groupId"),
    @NamedQuery(name = "Ugroup.findByGroupName", query = "SELECT u FROM Ugroup u WHERE u.groupName = :groupName"),
    @NamedQuery(name = "Ugroup.findByGroupNameLike", query = "SELECT u FROM Ugroup u WHERE u.groupName like :groupName"),    
    @NamedQuery(name = "Ugroup.findByDescription", query = "SELECT u FROM Ugroup u WHERE u.description = :description")})
public class Ugroup implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "group_id")
    private Long groupId;
    @Basic(optional = false)
    @Column(name = "group_name")
    private String groupName;
    @Column(name = "description")
    private String description;
    @JoinTable(name = "user_group", joinColumns = {
        @JoinColumn(name = "group_id", referencedColumnName = "group_id")}, inverseJoinColumns = {
        @JoinColumn(name = "user_id", referencedColumnName = "user_id")})
    @ManyToMany
    private Set<Appuser> appuserSet = new HashSet<>();

    public Ugroup() {
    }

    public Ugroup(Long groupId) {
        this.groupId = groupId;
    }

    public Ugroup(Long groupId, String groupName) {
        this.groupId = groupId;
        this.groupName = groupName;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Appuser> getAppuserSet() {
        return appuserSet;
    }

    public void setAppuserSet(Set<Appuser> appuserSet) {
        this.appuserSet = appuserSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (groupId != null ? groupId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ugroup)) {
            return false;
        }
        Ugroup other = (Ugroup) object;
        if ((this.groupId == null && other.groupId != null) || (this.groupId != null && !this.groupId.equals(other.groupId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.cn.al.teach.jpaexample.model.Ugroup[ groupId=" + groupId + " ]";
    }
    
}
