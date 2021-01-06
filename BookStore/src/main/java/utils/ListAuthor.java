package utils;

import entities.Author;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListAuthor{
    public static List<Author> listAuthor = new ArrayList<>(Arrays.asList(new Author(1,"J.K Rowlings"),
            new Author(2,"Tolkiens"),
            new Author(3,"Kim DUng")));
}
