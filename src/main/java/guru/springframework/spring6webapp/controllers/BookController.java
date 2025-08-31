package guru.springframework.spring6webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.spring6webapp.services.BookService;

@Controller
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/books")
    public String getBooks(Model model) {
        model.addAttribute("books", bookService.findAll()); // call a view named: books (map key books -> iterable of info)
        return "books";
    }
}
