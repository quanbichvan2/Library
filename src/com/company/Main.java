package com.company;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void printTheNameOfBooks(ArrayList<Book> bookShelf) {
        for (int i = 0; i < bookShelf.size(); i++) {
            String bookName = bookShelf.get(i).getNameOfBook();
            System.out.println(bookName); // in ra danh sách các tên sách đang có trong tủ sách
        }
    }

    public static void informationOfTheBook(Book book) {
        int ID = book.getId();
        System.out.println("the id: " + ID);
        String nameOfBook = book.getNameOfBook();
        System.out.println("the name: " + nameOfBook);
        int pride = book.getThePrice();
        System.out.println("the pride: " + pride);
        int page = book.getPage();
        System.out.println("the page: " + page);
        String type = book.getType();
        System.out.println("the type: " + type);

//        System.out.println("amount of book"+);
    }

    //id,tên,giá, số trang, thể loại
    static Scanner input = new Scanner(System.in);

    public static void show(Book[] bookshelf) {
        for (int i = 0; i < bookshelf.length; i++) {
            System.out.println(bookshelf[i] + "");
        }
    }


    public static void main(String[] args) {
        int a, b;
        int sum=0;
        ArrayList<Book> bookShelf = new ArrayList<>();
        ArrayList<Book> cart = new ArrayList<>();
        String[] typeList = {"children", "fiction", "romance", "comedy", "business", "guide", "cooking", "fantasy",
                "poem", "science", "law", "education"};
        while (true) {
            System.out.println("press 1 add object, press 2 to edit object, press 3 to buy a book");
            a = input.nextInt();
            String typeOfBook = null;
            if (a == 1) {
                int price, page, id;
                String name;
                String type;
                while (true) { //tạo vòng lặp để tạo 1 cuốn sách và quay lại để tạo thêm.
                    System.out.println("write the name of the book you want to add");
                    input.nextLine();
                    name = input.nextLine();// điền tên cuốn sách
                    System.out.println("the price of book");
                    price = input.nextInt(); // điền giá của sách
                    System.out.println("the page of book");
                    page = input.nextInt(); // điền số trang sách
                    System.out.println("Type of book in library");
                    for (int i = 0; i <= typeList.length; i++) {
                        for (int j = 0; j < typeList.length - 1; j++) {
                            System.out.print(typeList[j] + ", ");
                        }
                        System.out.print(typeList[typeList.length - 1] + ".");
                        break;
                    }
                    System.out.println("\nthe type of book");
                    input.nextLine();
                    type = input.nextLine().toLowerCase(Locale.ROOT); // điền thể loại sách và luôn viết thường ký tự
                    for (int i = 0; i < typeList.length; i++) { // tạo vòng lặp để chạy độ dài phần tử trong mục thể loại
                        String element = typeList[i]; // khai báo và gán 1 biến mới element = với vị trí phần tử của thể loại
                        if (type.equals(element)) { // đặt điều kiện NẾU element = vs phần tử trong thể loại
                            typeOfBook = element;
                            //cho mảng thể loại của sách (khai báo biển String = rỗng ở trên = với biến mới element
                            break; // thoát khỏi vòng lặp for với giá trị thêm vào là thể loại của sách.
                        }
                    }
                    if (typeOfBook != null) { // Nếu thể loại của sách khác với rỗng
                        Book book = new Book(1, name, price, page, typeOfBook);
                        //khởi tạo 1 biến mới tên sách thuộc biến sách với các thông số của class sách
                        bookShelf.add(book);// thêm biến mới (sách) vào kệ sách
                    } else {
                        System.out.println("choice again"); //Nếu else thì in chọn lại và lặp lại vòng lặp từ đầu)
                    }
                    System.out.println("the amount of book you want to add into storage: ");
                    int amountOfBook = input.nextInt();
                    break;// thoát khỏi vòng lặp while và trả về 1 cuốn sách vô kệ sách
                }
            }
            if (a == 2) {
                while (true) { // tạo vòng lặp để có thể quay lại các chức năng dưới dòng in
                    System.out.println("\npress 1 to check the list of books \npress 2 to delete the book, " +
                            "\npress 3 to find a book \npress else to return");
                    b = input.nextInt(); // nhập 1 số để khởi chạy chương trình con
                    while (true) {
                        if (b == 1) { // nếu số nhập vào bằng 1
                            System.out.println("the list of books: ");
                            for (int i = 0; i < bookShelf.size(); i++) { //chạy tủ sách để biết tủ sách có bn cuốn sách
                                String bookName; //khai báo 1 biến Tên Sách
                                bookName = bookShelf.get(i).getNameOfBook();
                                // gán biến Tên Sách để biết tên các loại sách trong tủ sách đang có.
                                System.out.println(bookName);// in ra các tên của sách đang có trong tủ
                            }
                        }
                        if (b == 2) {
                            while (true) {
                                System.out.println("choose the book you want to delete: " + "\nthe list of books: ");
                                printTheNameOfBooks(bookShelf);
                                System.out.println("write the book name you want to remove: ");
                                input.nextLine();
                                String nameOfBookRemove = input.nextLine(); // nhập tên sách cần xóa
                                for (int i = 0; i < bookShelf.size(); i++) {
                                    String bookName = bookShelf.get(i).getNameOfBook();
                                    if (nameOfBookRemove.equals(bookName)) {
                                        bookShelf.remove(i);
                                    }
                                }
                                System.out.println("the book in bookshelf now: ");
                                printTheNameOfBooks(bookShelf);
                                break;
                            }
                        }

                        if (b == 3) {
                            String nameBook;
                            System.out.println("find a book: ");
                            input.nextLine();
                            nameBook = input.nextLine();
                            for (int i = 0; i < bookShelf.size(); i++) {
                                // ket noi phan tu cua bookshelf vs namebook, trong bookshelf co' book tìm cách lấy nameofbook
                                Book bookAtIndexI; // khai báo sách ở vị trí i.
                                bookAtIndexI = bookShelf.get(i);
                                // kiểm tra namebook có = với nameOfBook.
                                if (bookAtIndexI.getNameOfBook().contains(nameBook)) {
                                    System.out.println(bookAtIndexI.getNameOfBook());
                                }
                                break;
                            }
                            break;
                        } else {
                            break;
                        }
                    }
                    break;
                }
            }
            if (a == 3) {
                while (true) {
                    System.out.println("\nWelcome you consumer:" + "\npress 1 to check the list of books" +
                            "\npress 2 to buy a book");
                    b = input.nextInt();
                    if (b == 1) {
                        System.out.println("the list of books we have in library");
                        printTheNameOfBooks(bookShelf);
                        System.out.println("write the name of book you want to search for information");
                        String search;
                        input.nextLine();
                        search = input.nextLine();
                        for (int i = 0; i < bookShelf.size(); i++) {
                            String bookName = bookShelf.get(i).getNameOfBook();
                            if (search.equals(bookName)) {
                                System.out.println("the information of the book: ");
                                informationOfTheBook(bookShelf.get(i));
                                break;
                            }
                        }
                    }
                    if (b == 2) {
                        while (true) {
                            System.out.println("\nwrite the book you want to buy");
                            String bookBuy;
                            input.nextLine();
                            bookBuy = input.nextLine();
                            for (int i = 0; i < bookShelf.size(); i++) {
                                String bookName = bookShelf.get(i).getNameOfBook();
                                if (bookBuy.equals(bookName)) {
                                    cart.add(bookShelf.get(i));
                                }
                            }
                            System.out.println("press 1 to payment" + "\npress 2 to continue buying a book");
                            int scan = input.nextInt();
                            if (scan == 1) {
                                for (int i=0;i<cart.size();i++){
                                    int pride = cart.get(i).getThePrice();
                                    System.out.println("the pride of book you need to pay: " + pride);
                                    sum = sum + pride;
                                }
                                System.out.println("the total $: "+ sum);
                            }
                        }
                    }
                }
            }
        }
    }
}
// sau khi bán sách phải trừ số lượng sách đang có
// khống chế sô lượng random cứng ko để nó chạy khác số so vs lần 1
// comment updates:
// random số lượng sách đang có trong thư viện
//            String[] type = {"Children", "fiction", "romance", "comedy", "business", "guide", "cooking", "fantasy",
//                    "poem", "science", "law", "education"};