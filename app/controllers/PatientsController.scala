package controllers

import mock.{MockPatientAttributes, MockPatientInputFields, MockRules}
import play.api.libs.concurrent.Execution.Implicits._
import scala.concurrent._

object PatientsController extends ResourcesController {

  def getPatientInputFields(preliminary: Option[Boolean]) = MyAction { request => {
    Future.successful(MockPatientInputFields.getMockedPreliminaryDiagnosisFields())
  }}

  def getPatientAttributes() = MyAction { request => {
    Future.successful(MockPatientAttributes.getMockedPatientAttributes())
  }}

}
