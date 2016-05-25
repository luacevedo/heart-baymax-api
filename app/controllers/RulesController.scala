package controllers

import db.MongoFactory
import mock.MockRules
import org.mongodb.scala._
import play.api.libs.concurrent.Execution.Implicits._
import scala.concurrent._

import helpers.ObservableHelper

object RulesController extends ResourcesController with ObservableHelper {

  def getRules() = MyAction { request => {

    val collection: MongoCollection[Document] = MongoFactory.getCollection("rules")

    println(collection.find().first().results())

    Future.successful(MockRules.getMockedRules)
  }}

}




