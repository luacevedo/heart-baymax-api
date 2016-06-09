package controllers

import providers.DiagnosisFieldsProvider

object DiagnosisFieldsController extends ResourcesController {

  val diagnosisFieldsProvider = new DiagnosisFieldsProvider()

  def getPatientInputFields(preliminary: Option[Boolean]) = {
    MyAction {
      request => {
        diagnosisFieldsProvider.getPreliminaryDiagnosisFields()
      }
    }
  }

}
