package lib;

import com.google.inject.Inject;
import entity.User;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;
import play.db.Database;

import javax.inject.Singleton;

@Singleton
public class DatabaseManager {
	private Jdbi dbi;

	@Inject
	public DatabaseManager(final Database database) {
		dbi = Jdbi.create(database.getDataSource());
		dbi.installPlugin(new SqlObjectPlugin());

		dbi.registerRowMapper(User.class,
			(rs, ctx) -> {
				final User user = new User();
				user.id = rs.getInt("id");
				return user;
			}
		);

		System.out.println("Yolo i exist");
	}

	public Jdbi getDbi() {
		return dbi;
	}
}
