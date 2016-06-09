package controllers

import db.MongoFactory
import mock.MockRules
import org.mongodb.scala._
import play.api.libs.concurrent.Execution.Implicits._
import scala.concurrent._

import helpers.ObservableHelper

object RulesController extends ResourcesController {

  def getRules() = MyAction { request => {
    Future.successful(MockRules.getMockedRules)
  }}

}




