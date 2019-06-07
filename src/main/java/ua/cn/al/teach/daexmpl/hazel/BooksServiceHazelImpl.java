/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.cn.al.teach.daexmpl.hazel;

import com.hazelcast.core.HazelcastInstance;
import ua.cn.al.teach.daexmpl.model.Book;
import ua.cn.al.teach.daexmpl.model.BookExamplar;
import ua.cn.al.teach.daexmpl.service.BooksService;

/**
 *
 * @author al
 */
public class BooksServiceHazelImpl implements BooksService{

    public BooksServiceHazelImpl(HazelcastInstance instance) {
        
    }

    @Override
    public Book addBook(Book b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BookExamplar addBookExemplar(BookExamplar be) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
