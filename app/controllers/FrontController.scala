package controllers

import com.google.inject.Inject
import lib.WebpackBuildFile
import play.Environment
import play.api.Configuration
import play.api.mvc._

class FrontController @Inject() (cc: ControllerComponents, env: Environment, config: Configuration) extends AbstractController(cc){
  def index = Action {
    //Ok(views.html.index.render(env, config.get[Int]("webpack.port"), WebpackBuildFile.jsBundle, WebpackBuildFile.cssBundle))
    Ok(views.html.index.render(env, config.get[Int]("webpack.port"), WebpackBuildFile.jsBundle, " "))
  }

  def indexWithRoute(x: String) = Action {
    //Ok(views.html.index.render(env, config.get[Int]("webpack.port"), WebpackBuildFile.jsBundle, WebpackBuildFile.cssBundle))
    Ok(views.html.index.render(env, config.get[Int]("webpack.port"), WebpackBuildFile.jsBundle, " "))
  }
}