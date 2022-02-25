package uz.pdp.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import uz.pdp.model.Book;
import uz.pdp.model.User;

import java.util.List;

@Component
public class UserRepository {
    @Autowired
    JdbcTemplate template;


    public UserRepository(JdbcTemplate template) {
        this.template = template;
    }

    public List<Book> getBooksByUserid(Integer userId){
        String query  = "select * from books where user_id = "+userId;
        return template.query(query, (rs, rowNum) -> {
            Book book = new Book();
            book.setId(rs.getInt("id"));
            book.setTitle(rs.getString("title"));
            book.setUser_id(rs.getInt("user_id"));
            book.setAuthors(rs.getString("authors"));
            book.setDescription(rs.getString("description"));
            return book;
        });
    }

    public User getUserByUserName(String userName) {
        String query = "select * from users where user_name = '"+userName+"'";
        try {
            return template.queryForObject(query,(rs, rowNum) -> {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUserName(rs.getString("user_name"));
                user.setPassword(rs.getString("password"));
                user.setFullName(rs.getString("full_name"));
                return user;
            });
        }catch (Exception e){
            return null;
        }
    }
    public User getUserById(Integer id) {
        String query = "select * from users where id = "+id;
        try {
            return template.queryForObject(query,(rs, rowNum) -> {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUserName(rs.getString("user_name"));
                user.setPassword(rs.getString("password"));
                user.setFullName(rs.getString("full_name"));
                return user;
            });
        }catch (Exception e){
            return null;
        }
    }

    public void save(User user) {
        String query = "insert into users(full_name, user_name, password) values ('"+user.getFullName()+"', '"+user.getUserName()+"', '"+user.getPassword()+"')";
        template.execute(query);
    }

    public void saveBook(Book book) {
        String query = "insert into books(title, description, user_id, authors) values ('"+book.getTitle()+"', '"+book.getDescription()+"',"+book.getUser_id()+" , '"+book.getAuthors()+"')";
        template.execute(query);
    }

    public void deleteBook(Integer id) {
        String query = "delete from books where id = "+id;
        template.execute(query);
    }
}
