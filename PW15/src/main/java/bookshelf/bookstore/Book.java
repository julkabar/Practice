/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookshelf.bookstore;

/**
 *
 * @author Admin
 */
public abstract class Book implements Cloneable {
    protected int ISBN;
    protected int pages;
    protected String genre;

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getISBN() {
        return ISBN;
    }

    public int getPages() {
        return pages;
    }

    public String getGenre() {
        return genre;
    }
    
    public abstract void printContent();
    
    @Override
    public Object clone() {
        Object cloneObject = null;
        try {
            cloneObject = super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("cloning failed");
            e.printStackTrace();
        }
        return cloneObject;
    }
}
