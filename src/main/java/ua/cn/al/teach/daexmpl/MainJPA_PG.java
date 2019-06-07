/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.cn.al.teach.daexmpl;

import ua.cn.al.teach.daexmpl.jpa.BooksServiceJPAImpl;
import ua.cn.al.teach.daexmpl.jpa.UserServiceJPAImpl;
import ua.cn.al.teach.daexmpl.service.BooksService;
import ua.cn.al.teach.daexmpl.service.UserService;

/**
 *
 * @author al
 */
public class MainJPA_PG {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BooksService booksService = new BooksServiceJPAImpl();
        UserService userService = new UserServiceJPAImpl();
        TestRunner tr = new TestRunner(booksService, userService);
        //need to exec it because... 
        tr.deleteAllUsers();
        tr.go();
    }
    
}
