package providers

import db.MongoFactory
import helpers.ObservableHelper
import models._
import org.bson.{BsonValue, BsonArray}
import org.mongodb.scala._
import org.mongodb.scala.bson.BsonDouble

import scala.collection.JavaConverters._
import scala.concurrent.Future
import scala.language.implicitConversions

class DiagnosisFieldsProvider extends ObservableHelper {

  implicit def preliminaryDiagnosisFieldsParser(document: Seq[Document]): Resource = {
    
    def parseBsonValueToFieldValue(bsonValue: BsonValue): FieldValue = {
      val valueDocument = bsonValue.asDocument()
      val key = valueDocument.get("key").asString().getValue
      val value = valueDocument.get("value").asString().getValue
      FieldValue(key, value)
    }
    
    def parseBsonValueToInputField(bsonInputField: BsonValue): InputField = {
      val inputFieldDocument = bsonInputField.asDocument()
      val id = inputFieldDocument.get("id").asString().getValue.toLong
      val labelMessage = inputFieldDocument.get("labelMessage").asString().getValue
      val rootToAffect = inputFieldDocument.get("rootToAffect").asString().getValue
      val dataType = inputFieldDocument.get("dataType").asString().getValue
      val fieldType = inputFieldDocument.get("fieldType").asString().getValue
      val values = inputFieldDocument.get("values").asArray().getValues.asScala.map {
        bsonValue => parseBsonValueToFieldValue(bsonValue)
      }.toList
      InputField(id, labelMessage, rootToAffect, dataType, fieldType, values)
    }
    
    val stepsList = document.map {
      document => {
        val inputFields = document.get[BsonArray]("inputFields").map(_.getValues.asScala).getOrElse(Nil).map {
          bsonInputField => parseBsonValueToInputField(bsonInputField)
        }.toList
        
        StepInputFields(document.get[BsonDouble]("step").map(_.asDouble().getValue).getOrElse(0), inputFields)
      }
    }.toList

    PreliminaryDiagnosisFieldsResource(stepsList)

  }

  def getPreliminaryDiagnosisFields(): Future[Resource] = {

    val collection: MongoCollection[Document] = MongoFactory.getCollection("stepstest02")

    Future.successful(collection.find().results())
  }

}
