package controllers;

import com.google.inject.Inject;
import com.typesafe.config.Config;
import lib.WebpackBuildFile;
import play.Environment;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Results;

public class Page extends Controller {
	@Inject
	Environment environment;
	@Inject
	Config configuration;


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
		return Results.ok("Hello World");
	}

}
