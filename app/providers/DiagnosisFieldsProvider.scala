package providers

import db.MongoFactory
import db.readers.PreliminaryDiagnosisReader
import helpers.ObservableHelper
import models._
import org.mongodb.scala._

import scala.concurrent.Future
import scala.language.implicitConversions

class DiagnosisFieldsProvider extends PreliminaryDiagnosisReader with ObservableHelper {

  def getPreliminaryDiagnosisFields(): Future[Resource] = {

    val collection: MongoCollection[Document] = MongoFactory.getCollection("stepstest02")

    Future.successful(collection.find().results())
  }

}
