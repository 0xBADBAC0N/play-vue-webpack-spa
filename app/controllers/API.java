package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import entity.User;
import lib.DatabaseManager;
import play.mvc.Controller;
import play.mvc.Result;
import repository.UserDao;

import java.util.List;


public class API extends Controller {
	@Inject
	DatabaseManager databaseManager;

	public Result Login() {
		final List<User> userNames = databaseManager.getJdbi().withExtension(UserDao.class, UserDao::listUsers);
		System.out.println(userNames);

		System.out.println("LÄUFT");

		System.out.println("alles banane");
		if(!request().hasBody()) {
			System.out.println("No body?");
			return badRequest();
		}

		final JsonNode json = request().body().asJson();
		System.out.println(json.toString());
		if(!json.has("email") || !json.has("password")) {
			System.out.println("Nope, no email/pw: " + json.toString());
			return badRequest();
		}

		System.out.println("email/Pw found");

		final String email = json.get("email").textValue();
		final String password = json.get("password").textValue();

		System.out.println("email -> " + email);
		System.out.println("Password -> " + password);

		final User user = databaseManager.getJdbi().withExtension(UserDao.class, dao -> dao.getUser(email, password));
		System.out.println("Result: " + user);

		if (user != null){
			// create session
			return ok("fakeSession");
		}


//		final Connection connection = database.getConnection();
//		System.out.println(connection.toString());
//		try {
//			final PreparedStatement preparedStatement = connection.prepareStatement(
//				"SELECT id FROM user WHERE email = ? AND password = SHA2(?, 512)"
//			);
//			preparedStatement.setString(1, email);
//			preparedStatement.setString(2, password);
//			final ResultSet resultSet = preparedStatement.executeQuery();
//			if(resultSet.next()) {
//				final int userId = resultSet.getInt("id");
//				System.out.println("userId: " + userId);
//				// create session
//			}
//			connection.close();
//
//			resultSet.close();
//
//		} catch(final SQLException e) {
//			e.printStackTrace();
//		}


//		if (Database.CheckCredentials(name, password)){
//			return ok(Database.GetSessionToken(name));
//		}


		return badRequest();
	}

	public Result AddItems() {
		// bilder[], titel, text


		return ok();
	}

	//	def getAllImages = Action {
///*    val mapper = new ObjectMapper()
//    val root: ObjectNode = mapper.createObjectNode()
//
//    val itemA: ObjectNode = mapper.createObjectNode()
//    itemA.put("id", "5001")
//    itemA.put("title", "title A")
//    itemA.put("voting", "200")
//    itemA.put("imgUrl", "https://i.pinimg.com/736x/2f/90/cb/2f90cb70a3aa8cb052cec613ec4849dc--funny-stuff-funny-things.jpg")
//
//    val list:List[_] = List(itemA)*/
//		val es = new util.ArrayList[String]()
//		es.add("asd")
//
//		val mapper = new ObjectMapper()
//
//		Ok(mapper.writeValueAsString(es))
//	}

}
