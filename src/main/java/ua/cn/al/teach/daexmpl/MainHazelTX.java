/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.cn.al.teach.daexmpl;

import com.hazelcast.config.Config;
import com.hazelcast.config.XmlConfigBuilder;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import ua.cn.al.teach.daexmpl.hazel.BooksServiceHazelImpl;
import ua.cn.al.teach.daexmpl.hazel.UserServiceHazelImpl;
import ua.cn.al.teach.daexmpl.hazel.UserServiceHazelTXImpl;
import ua.cn.al.teach.daexmpl.service.BooksService;
import ua.cn.al.teach.daexmpl.service.UserService;

/**
 *
 * @author al
 */
public class MainHazelTX {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Config config;
        InputStream hzConfig = Thread.currentThread().getContextClassLoader().getResourceAsStream("hazelcast.xml");
        if(hzConfig==null){
            config = new Config();
        }else{
            XmlConfigBuilder builder = new XmlConfigBuilder(hzConfig);
            config = builder.build();
        }
        HazelcastInstance instance = Hazelcast.newHazelcastInstance(config);
    
        BooksService booksService = new BooksServiceHazelImpl(instance);
        UserService userService = new UserServiceHazelTXImpl(instance);
        
        TestRunner tr = new TestRunner(booksService, userService);
        tr.go();
        System.out.println("Press Enter to shutdown");
        try {
            System.in.read();
        } catch (IOException ex) {
        }
        instance.shutdown();
        
    }
    
}
