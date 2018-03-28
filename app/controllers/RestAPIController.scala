package controllers

import java.util
import java.util._

import com.fasterxml.jackson.databind.ObjectMapper
import com.google.inject.Inject
import play.Environment
import play.api.Configuration
import play.api.mvc._
import play.libs.Json

class RestAPIController @Inject()(cc: ControllerComponents, env: Environment, config: Configuration) extends AbstractController(cc) {
  def helloWorld = Action {
    Ok("Hello World")
  }

  def getAllImages = Action {
/*    val mapper = new ObjectMapper()
    val root: ObjectNode = mapper.createObjectNode()

    val itemA: ObjectNode = mapper.createObjectNode()
    itemA.put("id", "5001")
    itemA.put("title", "title A")
    itemA.put("voting", "200")
    itemA.put("imgUrl", "https://i.pinimg.com/736x/2f/90/cb/2f90cb70a3aa8cb052cec613ec4849dc--funny-stuff-funny-things.jpg")

    val list:List[_] = List(itemA)*/
    val es = new util.ArrayList[String]()
    es.add("asd")

    val mapper = new ObjectMapper()

    Ok(mapper.writeValueAsString(es))
  }
}
