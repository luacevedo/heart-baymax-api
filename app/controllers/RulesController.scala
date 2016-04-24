package controllers

import mock.MockRules
import play.api.libs.concurrent.Execution.Implicits._
import scala.concurrent._

object RulesController extends ResourcesController {

  def getRules() = MyAction { request => {
    Future.successful(MockRules.getMockedRules)
  }}

}




