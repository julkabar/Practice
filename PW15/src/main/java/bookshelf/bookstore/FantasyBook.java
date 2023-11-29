/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookshelf.bookstore;

/**
 *
 * @author Admin
 */
public class FantasyBook extends Book {
    FantasyBook(){
        this.genre= "Fantasy";
    }
    
    @Override
    public void printContent() {
        System.out.println(this.getISBN()+": "+this.getGenre()+", "+this.getPages()+"pp.");
    }
    
}
