package lib;

import com.google.inject.Inject;
import entity.User;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;
import play.db.Database;

import javax.inject.Singleton;

@Singleton
public class DatabaseManager {
	private Jdbi jdbi;

	@Inject
	public DatabaseManager(final Database database) {
		jdbi = Jdbi.create(database.getDataSource());
		jdbi.installPlugin(new SqlObjectPlugin());

		jdbi.registerRowMapper(User.class,
			(rs, ctx) -> {
				final User user = new User();
				user.id = rs.getInt("id");
				user.display_name = rs.getString("display_name");
				user.email = rs.getString("email");
				user.passwordhash = rs.getString("passwordhash");

				return user;
			}
		);
	}

	public Jdbi getJdbi() {
		return jdbi;
	}
}
