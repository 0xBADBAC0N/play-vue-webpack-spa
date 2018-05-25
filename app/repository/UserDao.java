package repository;

import entity.User;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

public interface UserDao {
    @SqlUpdate("create table if not exists user (" +
        "id BIGINT UNSIGNED AUTO_INCREMENT," +
        "created_at timestamp default CURRENT_TIMESTAMP()," +
        "updated_at timestamp default CURRENT_TIMESTAMP()," +
        "display_name varchar(100) not null," +
        "email varchar(190) not null," +
        "session varchar(36)," +
        "passwordhash varchar(250) not null," +
        "PRIMARY KEY (`id`)," +
        "UNIQUE KEY `email` (`email`)" +
        ")"
    )
    void createTable();

    // todo rename pw to pwhash
    @SqlUpdate("INSERT INTO user (display_name, email, passwordhash) " +
        "VALUES (:display_name, :email, SHA2(CONCAT(:passwordhash, 'salt'), 512))"
    )
    int createUser(@Bind("display_name") String display_name, @Bind("email") String email, @Bind("passwordhash") String passwordhash);

    @SqlQuery("SELECT * FROM user")
    @RegisterBeanMapper(User.class)
    List<User> listUsers();

    @SqlQuery("SELECT * FROM user WHERE email = :email AND passwordhash = SHA2(CONCAT(:password, 'salt'), 512) LIMIT 1")
    User getUser(@Bind("email") String email, @Bind("password") String password);
}
