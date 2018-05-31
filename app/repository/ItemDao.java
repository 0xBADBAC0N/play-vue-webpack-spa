package repository;

import entity.Item;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

public interface ItemDao {
	@SqlUpdate("    CREATE TABLE IF NOT EXISTS items (\n" +
		"    id BIGINT UNSIGNED AUTO_INCREMENT,\n" +
		"    created_at timestamp default CURRENT_TIMESTAMP(),\n" +
		"    updated_at timestamp default CURRENT_TIMESTAMP(),\n" +
		"    set_json MEDIUMTEXT NOT NULL,\n" +
		"    title varchar(100) not null,\n" +
		"    desciption varchar(255) not null,\n" +
		"    created_from BIGINT UNSIGNED not null,\n" +
		"    PRIMARY KEY  (`id`),\n" +
		"    FOREIGN KEY (created_from) REFERENCES user(id)\n" +
		"    )"
	)
	void createTable();

	@SqlUpdate(" INSERT INTO items (set_json, title, desciption, created_from) " +
		"VALUES (:set_json, :title, :desciption, :created_from)"
	)
	int createItem(@Bind("display_name") String display_name, @Bind("email") String email, @Bind("passwordhash") String passwordhash);

	@SqlQuery("SELECT * FROM items")
	@RegisterBeanMapper(Item.class)
	List<Item> listItems();

	@SqlQuery("SELECT * FROM items WHERE id = :id LIMIT 1")
	Item getItem(@Bind("id") String id);

	@SqlQuery("SELECT * FROM items order by updated_at DESC LIMIT 100")
	List<Item> getLatestItems();
}
