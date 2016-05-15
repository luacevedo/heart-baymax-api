package controllers

import mock.{MockPatientFields, MockRules}
import play.api.libs.concurrent.Execution.Implicits._
import scala.concurrent._

object PatientsController extends ResourcesController {

  def getPatientFields(preliminary: Option[Boolean]) = MyAction { request => {
    Future.successful(MockPatientFields.getMockedPreliminaryDiagnosisFields())
  }}

}
