package pl.akademiakodu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.akademiakodu.model.Book;
import pl.akademiakodu.service.Service;

import javax.validation.Valid;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private Service bookService;
    @GetMapping
    public ModelAndView getBooks() {         //metoda pobiera listę
        ModelAndView mav = new ModelAndView("book-list");
        mav.addObject("list", bookService.getList());
        return mav;
    }
    @GetMapping("/add")
    public ModelAndView addBookForm() {     //wyświetla formularz dodawania nowej ksiązki
        ModelAndView mav = new ModelAndView("book-form");
        mav.addObject("book", new Book());
        return mav;
    }
    @PostMapping("/add")
    public ModelAndView saveBook(@Valid @ModelAttribute("book") Book book, BindingResult bindingResult) {

        System.out.println(book);
        ModelAndView mav = new ModelAndView();

        if (bindingResult.hasErrors()) {
            mav.addObject("book", book);
            mav.setViewName("book-form");

        } else {
            bookService.save(book);
            mav.setViewName("book-list");
        }
        return mav;
    }
    @GetMapping("/{id}")
    public ModelAndView getDetails(@PathVariable("id") int bookId) {

        return new ModelAndView("book-details",
                "book", bookService.read(bookId));
    }
    @GetMapping("/remove/{id}")
    public String deleteBook(@PathVariable("id") int bookId) {
        bookService.remove(bookId);
        return "redirect:/book";
    }
    @GetMapping("/edit/{id}")
    public ModelAndView editBookForm(@PathVariable("id") int bookId) {
        ModelAndView mav = new ModelAndView("book-form");
        mav.addObject("book", bookService.read(bookId));
        return mav;
    }
}