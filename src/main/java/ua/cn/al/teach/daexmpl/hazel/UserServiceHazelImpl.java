
package ua.cn.al.teach.daexmpl.hazel;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import com.hazelcast.query.Predicate;
import com.hazelcast.query.Predicates;
import java.util.ArrayList;
import java.util.List;
import ua.cn.al.teach.daexmpl.model.Appuser;
import ua.cn.al.teach.daexmpl.model.Ugroup;
import ua.cn.al.teach.daexmpl.service.UserService;

/**
 *
 * @author al
 */
public class UserServiceHazelImpl implements UserService{
    public static final String USERS_MAP_NAME="users";
    public static final String GROUPS_MAP_NAME="ugroups";
    
    private final IMap<Long,Appuser> usersMap;
    private final IMap<Long,Ugroup> groupsMap;
    
    public UserServiceHazelImpl(HazelcastInstance instance) {
        usersMap=instance.getMap(USERS_MAP_NAME);
        groupsMap=instance.getMap(GROUPS_MAP_NAME);
    }

        
    @Override
    public Appuser addUser(Appuser u) {
        return usersMap.put(u.getUserId(), u);
    }

    @Override
    public void deleteUser(Long userId) {
        usersMap.delete(userId);
    }

    @Override
    public Appuser getUser(Long userId) {
        return usersMap.get(userId);
    }

    @Override
    public Appuser updateUser(Appuser u) {
        return usersMap.replace(u.getUserId(), u);        
    }

    @Override
    public List<Appuser> findUserByName(String name) {
        Predicate p = Predicates.like("username", name);
        return new ArrayList<>(usersMap.values(p));
    }

    @Override
    public Ugroup addGroup(Ugroup u) {
       return groupsMap.put(u.getGroupId(), u);
    }

    @Override
    public void deleteGroup(Long groupId) {
       groupsMap.delete(groupId);
    }

    @Override
    public Ugroup getGroup(Long groupId) {
        return groupsMap.get(groupId);
    }

    @Override
    public List<Ugroup> findGroupByName(String name) {
        Predicate p = Predicates.like("groupName", name);
        return new ArrayList<>(groupsMap.values(p));
    }

    @Override
    public boolean addUserToGroup(Long userId, Long groupId) {
        boolean res = false;
        Appuser u = usersMap.get(userId);
        Ugroup g = groupsMap.get(groupId);
        if(u!=null && g!=null){
            g.getAppuserSet().add(u);
            u.getUgroupSet().add(g);
            res=true;
        }
        return res;
    }

    @Override
    public boolean delUserFromGroup(Long userId, Long groupId) {
        boolean res = false;
        Appuser u = usersMap.get(userId);
        Ugroup g = groupsMap.get(groupId);
        if(u!=null && g!=null){
            g.getAppuserSet().remove(u);
            u.getUgroupSet().remove(g);
            res=true;
        }
        return res;
    }

    @Override
    public List<Appuser> getAllUsers() {
        return new ArrayList<>(usersMap.values());
    }

    @Override
    public List<Ugroup> getAllGroups() {
        return new ArrayList<>(groupsMap.values());
    }

    @Override
    public void deleteAll() {
        usersMap.clear();
        groupsMap.clear();
    }
    
}
