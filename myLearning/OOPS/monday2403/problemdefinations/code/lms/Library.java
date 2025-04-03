// package monday2403.problemdefinations.code.lms;

import java.util.List;

public class Library {

    private String name;
    private String address;
    private List<Book> listOfBooks;
    private List<Member> listOfMembers;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Book> getListOfBooks() {
        return listOfBooks;
    }

    public void setListOfBooks(List<Book> listOfBooks) {
        this.listOfBooks = listOfBooks;
    }

    public List<Member> getListOfMembers() {
        return listOfMembers;
    }

    public void setListOfMembers(List<Member> listOfMembers) {
        this.listOfMembers = listOfMembers;
    }

    public void addBook(Book book) {}
}
// removeBook(), searchBookByTitle(), searchBookByAuthor(), displayAvailableBooks()
