package controllers

import mock.MockPatientAttributes

import scala.concurrent._

object PatientsController extends ResourcesController {

  def getPatientAttributes() = MyAction { request => {
    Future.successful(MockPatientAttributes.getMockedPatientAttributes())
  }
  }

}
