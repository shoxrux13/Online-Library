package uz.pdp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.pdp.model.Book;
import uz.pdp.services.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    UserService userService;

    @GetMapping
    public String getBooks(HttpServletRequest req, Model model){
        HttpSession session = req.getSession(false);
        Object userId = session.getAttribute("userId");
        if (userId != null) {
            Integer userId1 = (Integer) userId;
            model.addAttribute("books",userService.getBooksByUserId(userId1));
            return "view-books";
        }
        return "index";
    }
    @PostMapping("/add")
    public String addBook( Book book, HttpServletRequest request){
        HttpSession session = request.getSession(false);
        Object userId = session.getAttribute("userId");
        if (userId != null) {
            book.setUser_id((Integer) userId);
            userService.saveBook(book);
            return "redirect:/books";
        }
        return null;
    }

    @GetMapping ("/delete/{id}")
    public String deleteBook(@PathVariable Integer id){
        userService.deleteBook(id);
        return "redirect:/books";
    }
    @GetMapping("/add")
    public String addBook(){
        return "add-book";
    }

}
