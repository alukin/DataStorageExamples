/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.cn.al.teach.daexmpl.service;

import java.util.List;
import ua.cn.al.teach.daexmpl.model.Appuser;
import ua.cn.al.teach.daexmpl.model.Ugroup;

/**
 *
 * @author al
 */
public interface UserService {
    public Appuser addUser(Appuser u);
    public void deleteUser(Long userId);
    public Appuser getUser(Long userId);
    public Appuser updateUser(Appuser u);
    public List<Appuser> findUserByName(String name);
    public Ugroup addGroup(Ugroup u);
    public void deleteGroup(Long groupId);
    public Ugroup getGroup(Long groupId);
    public List<Ugroup> findGroupByName(String name);
    public boolean addUserToGroup(Long userId, Long groupId);    
    public boolean delUserFromGroup(Long userId, Long groupId);
    public List<Appuser> getAllUsers();
    public List<Ugroup> getAllGroups();
    public void deleteAll();    
}
