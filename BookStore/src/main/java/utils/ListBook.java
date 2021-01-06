package utils;

import entities.Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListBook {
    public static List<Book> listBook = new ArrayList<>(Arrays.asList(new Book(1,"Harry Potter","JK Rowling"),
            new Book(2,"Lord of the Rings","Tolkien"),
            new Book(3,"Y Thien Do Long Ky",""),
            new Book(4,"Anh Hung Xa Dieu","Kim Dung")));
}
