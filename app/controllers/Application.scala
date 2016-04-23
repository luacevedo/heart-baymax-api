package controllers

import play.api.mvc._

import scala.concurrent._
import scala.language.postfixOps

object Application extends Controller {

  def index = Action { request =>
    Ok("HEART BAYMAX API")
  }

}

