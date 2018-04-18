package repository;

import entity.User;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.BindBean;
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
        "password varchar(250) not null," +
        "PRIMARY KEY (`id`)," +
        "UNIQUE KEY `email` (`email`)" +
        ")"
    )
    void createTable();

    @SqlUpdate("INSERT INTO user (display_name, email, password) " +
        "VALUES (:name, :email, SHA2(CONCAT(:password, 'salt'), 512))"
    )
    void insertBean(@BindBean User user);

    @SqlQuery("SELECT * FROM user")
    @RegisterBeanMapper(User.class)
    List<User> listUsers();
}
