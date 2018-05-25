package controllers;

import com.google.inject.Inject;
import com.typesafe.config.Config;
import entity.User;
import lib.DatabaseManager;
import lib.WebpackBuildFile;
import play.Environment;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Results;
import repository.UserDao;

public class Page extends Controller {
	@Inject
	Environment environment;
	@Inject
	Config configuration;
	@Inject
	DatabaseManager databaseManager;

	public Result index() {
		return Results.ok(
			views.html.index.render(
				environment,
				configuration.getInt("webpack.port"),
				WebpackBuildFile.getJsBundle()
			)
		);
	}

	public Result indexWithRoute(final String unused) {
		return index();
	}

	public Result GetHelloWorld() {
		final StringBuilder sb = new StringBuilder();

		//final int userId = databaseManager.getJdbi().withExtension(UserDao.class, dao -> dao.createUser("nameA", "nameA@test.com", "passwordA"));

		final User user = databaseManager.getJdbi().withExtension(UserDao.class, dao -> dao.getUser(request().getHeaders().get("name").get(), request().getHeaders().get("password").get()));


		sb.append(user.toString() + "\n");
		System.out.println(user);

		request().getHeaders().toMap().forEach((a, b) -> System.out.println(a + " : " + b));
		return Results.ok("Hello World\n" + sb.toString());
	}

	public Result getSession() {
		return Results.ok("WIP");
	}

}

