package uz.pdp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.model.Book;
import uz.pdp.model.User;
import uz.pdp.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<Book> getBooksByUserId(Integer id) {
        return userRepository.getBooksByUserid(id);
    }

    public User getUserByUserName(String userName){
        return userRepository.getUserByUserName(userName);
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public void saveBook(Book book) {
        userRepository.saveBook(book);
    }

    public void deleteBook(Integer id) {
        userRepository.deleteBook(id);
    }
}
