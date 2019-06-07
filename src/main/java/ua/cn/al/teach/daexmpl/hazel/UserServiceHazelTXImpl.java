
package ua.cn.al.teach.daexmpl.hazel;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import com.hazelcast.core.TransactionalMap;
import com.hazelcast.query.Predicate;
import com.hazelcast.query.Predicates;
import com.hazelcast.transaction.TransactionContext;
import com.hazelcast.transaction.TransactionOptions;
import com.hazelcast.transaction.TransactionOptions.TransactionType;
import java.util.ArrayList;
import java.util.List;
import ua.cn.al.teach.daexmpl.model.Appuser;
import ua.cn.al.teach.daexmpl.model.Ugroup;
import ua.cn.al.teach.daexmpl.service.UserService;

/**
 *
 * @author al
 */
public class UserServiceHazelTXImpl implements UserService{
    public static final String USERS_MAP_NAME="users";
    public static final String GROUPS_MAP_NAME="ugroups";
    private final HazelcastInstance instance;

    
    public UserServiceHazelTXImpl(HazelcastInstance instance) {
        TransactionOptions options = new TransactionOptions().setTransactionType(TransactionType.TWO_PHASE);
        this.instance=instance;        
    }

        
    @Override
    public Appuser addUser(Appuser u) {
        TransactionContext context = instance.newTransactionContext();
        context.beginTransaction();
        TransactionalMap<Long,Appuser> usersMap = context.getMap(USERS_MAP_NAME);
        Appuser res = usersMap.put(u.getUserId(), u);
        context.commitTransaction();
        return res;
    }

    @Override
    public void deleteUser(Long userId) {
        TransactionContext context = instance.newTransactionContext();
        context.beginTransaction();
        TransactionalMap<Long,Appuser> usersMap = context.getMap(USERS_MAP_NAME);
        usersMap.delete(userId);
        context.commitTransaction();
    }

    @Override
    public Appuser getUser(Long userId) {
        IMap<Long,Appuser> usersMap = instance.getMap(USERS_MAP_NAME);
        return usersMap.get(userId);
    }

    @Override
    public Appuser updateUser(Appuser u) {
        TransactionContext context = instance.newTransactionContext();
        context.beginTransaction();
        TransactionalMap<Long,Appuser> usersMap = context.getMap(USERS_MAP_NAME);
        Appuser res = usersMap.replace(u.getUserId(), u);        
        context.commitTransaction();
        return res;
    }

    @Override
    public List<Appuser> findUserByName(String name) {
        IMap<Long,Appuser> usersMap = instance.getMap(USERS_MAP_NAME);
        Predicate p = Predicates.like("username", name);
        return new ArrayList<>(usersMap.values(p));
    }

    @Override
    public Ugroup addGroup(Ugroup u) {
        TransactionContext context = instance.newTransactionContext();
        context.beginTransaction();
        TransactionalMap<Long,Ugroup> groupsMap=context.getMap(GROUPS_MAP_NAME);        
        Ugroup res = groupsMap.put(u.getGroupId(), u);
        context.commitTransaction();
        return res;
    }

    @Override
    public void deleteGroup(Long groupId) {
       TransactionContext context = instance.newTransactionContext();
       context.beginTransaction();
       TransactionalMap<Long,Ugroup> groupsMap=context.getMap(GROUPS_MAP_NAME);
       groupsMap.delete(groupId);
       context.commitTransaction();
    }

    @Override
    public Ugroup getGroup(Long groupId) {
        IMap<Long,Ugroup> groupsMap=instance.getMap(GROUPS_MAP_NAME);         
        return groupsMap.get(groupId);
    }

    @Override
    public List<Ugroup> findGroupByName(String name) {
        IMap<Long,Ugroup> groupsMap=instance.getMap(GROUPS_MAP_NAME);
        Predicate p = Predicates.like("groupName", name);
        return new ArrayList<>(groupsMap.values(p));
    }

    @Override
    public boolean addUserToGroup(Long userId, Long groupId) {
        boolean res = false;
        TransactionContext context = instance.newTransactionContext();
        context.beginTransaction();        
        TransactionalMap<Long,Ugroup> groupsMap=context.getMap(GROUPS_MAP_NAME);
        TransactionalMap<Long,Appuser> usersMap = context.getMap(USERS_MAP_NAME);
        Appuser u = usersMap.get(userId);
        Ugroup g = groupsMap.get(groupId);
        if(u!=null && g!=null){
            g.getAppuserSet().add(u);
            u.getUgroupSet().add(g);
            res=true;
        }
        context.commitTransaction();
        return res;
    }

    @Override
    public boolean delUserFromGroup(Long userId, Long groupId) {
        boolean res = false;
        TransactionContext context = instance.newTransactionContext();
        context.beginTransaction();
        TransactionalMap<Long,Ugroup> groupsMap=context.getMap(GROUPS_MAP_NAME);
        TransactionalMap<Long,Appuser> usersMap = context.getMap(USERS_MAP_NAME);
        Appuser u = usersMap.get(userId);
        Ugroup g = groupsMap.get(groupId);
        if(u!=null && g!=null){
            g.getAppuserSet().remove(u);
            u.getUgroupSet().remove(g);
            res=true;
        }
        context.commitTransaction();
        return res;
    }

    @Override
    public List<Appuser> getAllUsers() {
        IMap<Long,Appuser> usersMap = instance.getMap(USERS_MAP_NAME);
        return new ArrayList<>(usersMap.values());
    }

    @Override
    public List<Ugroup> getAllGroups() {
        IMap<Long,Ugroup> groupsMap=instance.getMap(GROUPS_MAP_NAME);         
        return new ArrayList<>(groupsMap.values());
    }

    @Override
    public void deleteAll() {
        TransactionContext context = instance.newTransactionContext();
        context.beginTransaction();
        TransactionalMap<Long,Ugroup> groupsMap=context.getMap(GROUPS_MAP_NAME);
        TransactionalMap<Long,Appuser> usersMap = context.getMap(USERS_MAP_NAME);      
        for(Long uid : usersMap.keySet()){
            usersMap.delete(uid);
        }
        for(Long gid : groupsMap.keySet()){
            groupsMap.delete(gid);
        }
        context.commitTransaction();
    }
    
}
