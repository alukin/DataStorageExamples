/*
 * Copyright (C) 2019 Oleksiy Lukin 
 */
package ua.cn.al.teach.daexmpl.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import ua.cn.al.teach.daexmpl.model.Appuser;
import ua.cn.al.teach.daexmpl.model.Ugroup;
import ua.cn.al.teach.daexmpl.service.DBConfig;
import ua.cn.al.teach.daexmpl.service.UserService;

/**
 * JPA/EM mased implementation
 * @author Oleksiy Lukin <alukin@gmail.com>?
 */
public class UserServiceJPAImpl implements UserService{
    public EntityManager em = DBConfig.createEmFactory().createEntityManager();
    @Override
    public Appuser addUser(Appuser u) {
        em.getTransaction().begin();
        em.persist(u);
        em.getTransaction().commit();
        return getUser(u.getUserId());
    }

    @Override
    public void deleteUser(Long userId) {
        em.getTransaction().begin();
        Appuser u = em.find(Appuser.class, userId);
        if(u!=null){
            em.remove(u);
        }
        em.getTransaction().commit();
    }

    @Override
    public Appuser getUser(Long userId) {
        return em.find(Appuser.class, userId);
    }

    @Override
    public Appuser updateUser(Appuser u) {
        em.getTransaction().begin();
        u=em.merge(u);
        em.getTransaction().commit();
        return u;
    }

    @Override
    public Ugroup addGroup(Ugroup u) {
        em.getTransaction().begin();
        u=em.merge(u);
        em.getTransaction().commit();
        return u;
    }

    @Override
    public void deleteGroup(Long groupId) {
        em.getTransaction().begin();
        Ugroup u = em.find(Ugroup.class, groupId);
        if(u!=null){
            em.remove(u);
        }
        em.getTransaction().commit();
    }

    @Override
    public Ugroup getGroup(Long groupId) {
        return em.find(Ugroup.class, groupId);
    }

    @Override
    public boolean addUserToGroup(Long userId, Long groupId) {
        boolean res = false;
        Ugroup g = getGroup(groupId);
        Appuser u = getUser(userId);
        if(g!=null && u!=null){
            em.getTransaction().begin();
            u.getUgroupSet().add(g);
            g.getAppuserSet().add(u);
            em.merge(u);
            em.merge(g);
            em.getTransaction().commit();
            res=true;
        }
        return res;
    }

    @Override
    public boolean delUserFromGroup(Long userId, Long groupId) {
        boolean res = false;
        Ugroup g = getGroup(groupId);
        Appuser u = getUser(userId);
        if(g!=null && u!=null){
            em.getTransaction().begin();
            u.getUgroupSet().remove(g);
            g.getAppuserSet().remove(u);
            em.merge(u);
            em.merge(g);
            em.getTransaction().commit();
            res=true;
        }
        return res;
    }

    @Override
    public List<Appuser> getAllUsers() {
        TypedQuery<Appuser> namedQuery = em.createNamedQuery("Appuser.getAll", Appuser.class);
        return namedQuery.getResultList();
    }

    @Override
    public List<Ugroup> getAllGroups() {
        TypedQuery<Ugroup> namedQuery = em.createNamedQuery("Ugroup.getAll", Ugroup.class);
        return namedQuery.getResultList();
    }

    @Override
    public void deleteAll() {
        em.getTransaction().begin();
        Query namedQuery1 = em.createNamedQuery("Userdetails.deleteAll");
        namedQuery1.executeUpdate();
        Query namedQuery3 = em.createNamedQuery("Ugroup.deleteAll");
        namedQuery3.executeUpdate();
        Query namedQuery2 = em.createNamedQuery("Appuser.deleteAll");
        namedQuery2.executeUpdate();        
        em.getTransaction().commit();
    }

    @Override
    public List<Appuser> findUserByName(String name) {
        TypedQuery<Appuser> namedQuery = em.createNamedQuery("Appuser.findByUsernameLike", Appuser.class);
        namedQuery.setParameter("username", name);
        return namedQuery.getResultList();
    }

    @Override
    public List<Ugroup> findGroupByName(String name) {
        TypedQuery<Ugroup> namedQuery = em.createNamedQuery("Ugroup.findByGroupNameLike", Ugroup.class);
        namedQuery.setParameter("groupName", name);
        return namedQuery.getResultList();
    }
    
}
