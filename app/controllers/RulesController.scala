package controllers

import db.MongoFactory
import mock.MockRules
import org.mongodb.scala._
import play.api.libs.concurrent.Execution.Implicits._
import scala.concurrent._

object RulesController extends ResourcesController {

  def getRules() = MyAction { request => {

    val doc: Document = Document("_id" -> 0, "name" -> "MongoDB", "type" -> "database",
      "count" -> 1, "info" -> Document("x" -> 203, "y" -> 102))

    val collection: MongoCollection[Document] = MongoFactory.getCollection()

    val d: Either[String, Document]  = collection.find().first().subscribe(new Observer[Document] {

      override def onError(e: Throwable): Document = doc

      override def onComplete(): Document = doc

      override def onNext(result: Document): Document = result
    })

    collection.find().first().

    val doc: Document = Document("_id" -> 0, "name" -> "MongoDB", "type" -> "database",
      "count" -> 1, "info" -> Document("x" -> 203, "y" -> 102))


//    collection.insertOne(doc).subscribe(new Observer[Completed] {
//
//      override def onNext(result: Completed): Unit = println("Inserted")
//
//      override def onError(e: Throwable): Unit = println("Failed "+e.toString)
//
//      override def onComplete(): Unit = println("Completed")
//    })


    Future.successful(MockRules.getMockedRules)
  }}

}




