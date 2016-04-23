package controllers

import models.{Rule}
import play.api.libs.concurrent.Execution.Implicits._
import scala.concurrent._

object RulesController extends ResourcesController {

  def getRules() = MyAction { request => {
    Future.successful(Rule())
  }}

}




