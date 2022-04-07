package com.company;

public class Book {
    private int id;
    private String nameOfBook;
    private int thePrice;
    private int page;
    private String type;

    public Book(int id, String nameOfBook, int thePrice, int page, String type) {
        this.id = id;
        this.nameOfBook = nameOfBook; // giá trị của name of book
        this.thePrice = thePrice;
        this.page = page;
        this.type = type;
    }

    //muốn có số lượng sách thì phải random số sách int
    public String getNameOfBook() {return nameOfBook;}
    public int getThePrice(){return this.thePrice;}
    public int getPage(){return this.page;}
    public String getType() {return this.type;}
    public int getId(){return this.id;}
}





