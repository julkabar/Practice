/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookshelf;

import bookshelf.bookstore.Book;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class BookShelf {
    private static BookShelf instance;
    private List<Book> storage;
    
    private BookShelf(){
    this.storage=new LinkedList<Book>();
    }
    
    public static BookShelf getInstance(){
        if(instance==null){
            instance=new BookShelf();
        }
        return instance;
    }
       
    public void printContent(){
        System.out.println("On my shelf:");
        for(Book b:storage){
            b.printContent();
        }
    }
    
    public void addBook(Book b){
        storage.add(b);
    }
}
