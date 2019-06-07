/*
 * Copyright (C) 2019 Oleksiy Lukin 
 */
package ua.cn.al.teach.daexmpl.service;

import ua.cn.al.teach.daexmpl.model.Book;
import ua.cn.al.teach.daexmpl.model.BookExamplar;

/**
 *
 * @author Oleksiy Lukin <alukin@gmail.com>?
 */
public interface BooksService {
    public Book addBook(Book b);
    public BookExamplar addBookExemplar(BookExamplar be);
}
