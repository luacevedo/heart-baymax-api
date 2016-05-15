package mock

import models.{PatientAttribute, PatientAttributesResource}

object MockPatientAttributes {

  def getMockedPatientAttributes(): PatientAttributesResource = {
    val pulmonaryEdema = PatientAttribute(1L, "EssentialSymptoms.PulmonaryEdema", "boolean")
    val dyspnoea = PatientAttribute(2L, "EssentialSymptoms.Dyspnoea", "boolean")
    val orthopnea = PatientAttribute(3L, "EssentialSymptoms.Orthopnoea", "boolean")
    val valSE = PatientAttribute(2L, "InitialPhysicalState.EssentialSymptomsAssessment", "integer")
    val essentialSymptoms = PatientAttribute(3L, "InitialPhysicalState.EssentialSymptoms", "list")
    val symptomsType = PatientAttribute(4L, "PreliminaryDiagnosis.SymptomsType", "string")

    PatientAttributesResource(List(pulmonaryEdema, dyspnoea, orthopnea, valSE, essentialSymptoms, symptomsType))
  }

}
