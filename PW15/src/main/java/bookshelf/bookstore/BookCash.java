/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookshelf.bookstore;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Admin
 */
public class BookCash {
    private static Map <Integer, Book > bookMap = new HashMap < Integer, Book > ();
    
    public static Book getBook(int id) {
        Book toBeClonedBook = bookMap.get(id);
        return (Book) toBeClonedBook.clone();
    }

    public static void loadCache() {
        FantasyBook fb1 = new FantasyBook();
        bookMap.put(1, fb1);

        DetectiveBook db1 = new DetectiveBook();
        db1.setColor(true);
        bookMap.put(2, db1);

        DetectiveBook db2 = new DetectiveBook();
        bookMap.put(3, db2);

    }
}
