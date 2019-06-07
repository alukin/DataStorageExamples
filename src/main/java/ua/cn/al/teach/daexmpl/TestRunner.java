/*
 * Copyright (C) 2019 Oleksiy Lukin 
 */
package ua.cn.al.teach.daexmpl;

import java.util.List;
import ua.cn.al.teach.daexmpl.model.Appuser;
import ua.cn.al.teach.daexmpl.model.Ugroup;
import ua.cn.al.teach.daexmpl.model.Userdetails;
import ua.cn.al.teach.daexmpl.service.BooksService;
import ua.cn.al.teach.daexmpl.service.UserService;

/**
 *
 * @author Oleksiy Lukin <alukin@gmail.com>?
 */
public class TestRunner {
    private final BooksService bookService;
    private final UserService userService;

    public TestRunner(BooksService bookService, UserService userService) {
        this.bookService = bookService;
        this.userService = userService;
    }
    public Long go(){
        System.out.println("============ Populating user and group store");
        Long ms_pupulate = populateUsers(TestConfig.n_users, TestConfig.n_groups);
        System.out.println("============ Ellapsed time, ms: "+ms_pupulate);
        System.out.println("============ Testing finders in user and group sotore");
        Long ms_finders =  finderByNames();
        System.out.println("============ Ellapsed time, ms: "+ms_finders);        
        System.out.println("============ Deleting user and group store");
        Long ms_delete = deleteAllUsers();
        System.out.println("============ Ellapsed time, ms: "+ms_delete); 
        Long ms_res=ms_pupulate+ms_finders+ms_delete;
        System.out.println("============ Total time, ms: "+ms_res); 
        return ms_res;
        
    }
    public Long populateUsers(int users, int groups){
        Long start = System.currentTimeMillis();
        for(long i = 0; i<users; i++){
            Appuser u = new Appuser();
            u.setCreatedBy("TestRunner");
            u.setUserId(i);
            u.setEmail("email"+i+"@test.com");
            u.setUsername("user"+1);
            u.setPasswdHash(""+i);
            Userdetails ud = new Userdetails(i);
            ud.setFirstName("firstName"+i);
            ud.setAddress("address"+i);
            u.setUserdetails(ud);
            ud.setAppuser(u);
            userService.addUser(u);
        }
        for(long j=0; j<groups; j++ ){
            Ugroup g = new Ugroup();
            g.setGroupId(j);
            g.setGroupName("group"+j);
            g.setDescription("Group from tests");
            userService.addGroup(g);
        }
        for(long i = 0; i<users; i++){
            Long gn = Math.round(Math.random()*groups);
            userService.addUserToGroup(i, gn);
        }
        return System.currentTimeMillis()-start;
    }
    
    public Long finderByNames(){
        Long start = System.currentTimeMillis();
        List<Appuser> ul = userService.findUserByName("user%");
        List<Ugroup> gl = userService.findGroupByName("group%");
        System.out.println("Found users:"+ul.size()+" groups: "+gl.size());
        return System.currentTimeMillis()-start;  
    }
    
    public Long deleteAllUsers(){
      Long start = System.currentTimeMillis();
      userService.deleteAll();
      return System.currentTimeMillis()-start;  
    }
}
