package dao;

import entities.Book;
import utils.ListBook;

import java.util.List;
import java.util.stream.Collectors;

public class BookDaoImpl implements BookDao{

    @Override
    public List<Book> getAll() {

        return ListBook.listBook;
    }

    @Override
    public List<Book> getBooks(String name) {
        return ListBook.listBook.stream().filter(book->book.getName().equals(name)).collect(Collectors.toList());
    }

    @Override
    public List<Book> getBooksByAuthor(String authorName) {
        return ListBook.listBook.stream().filter(book->book.getAuthor().equals(authorName)).collect(Collectors.toList());
    }

    @Override
    public boolean insert(Book book) {
        if(book.getName()==null || book.getName().equals("")){
            return false;
        }
        Book checkedBookAvailable = ListBook.listBook.stream().filter(bookAvailable->bookAvailable.equals(book)).findAny().orElse(null);
        if(checkedBookAvailable!=null){
            return false;
        }
        return ListBook.listBook.add(book);
    }

    @Override
    public boolean delete(Integer id) {
        if(id==null){
            return false;
        }
        List<Book> list = ListBook.listBook;
        for(int i =0; i<list.size();i++){
            if(list.get(i).getId()==id){
                ListBook.listBook.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean update(Integer id, String name, String author) {
        if(name==null){
            return false;
        }
        Book checkedBookAvailable = ListBook.listBook.stream().filter(bookAvailable->bookAvailable.equals(new Book(id,name,author))).findAny().orElse(null);
        if(checkedBookAvailable!=null){
            return false;
        }
        for(int i =0; i<ListBook.listBook.size();i++){
            if(ListBook.listBook.get(i).getId()==id){
                ListBook.listBook.get(i).setName(name);
                ListBook.listBook.get(i).setAuthor(author);
                return true;
            }
        }
        return false;
    }
}
