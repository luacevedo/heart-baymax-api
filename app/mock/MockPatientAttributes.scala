package mock

import models.{PatientAttribute, PatientAttributesResource}

object MockPatientAttributes {

  def getMockedPatientAttributes(): PatientAttributesResource = {
    val pulmonaryEdema = PatientAttribute(1L, "EssentialSymptoms.PulmonaryEdema", "boolean")
    val dyspnoea = PatientAttribute(2L, "EssentialSymptoms.Dyspnoea", "boolean")
    val orthopnea = PatientAttribute(3L, "EssentialSymptoms.Orthopnoea", "boolean")
    val lowerLimbEdema = PatientAttribute(4L, "EssentialSymptoms.LowerLimbEdema", "boolean")
    val valSE = PatientAttribute(5L, "InitialPhysicalState.EssentialSymptomsAssessment", "integer")
    val essentialSymptoms = PatientAttribute(6L, "InitialPhysicalState.EssentialSymptoms", "list")
    val symptomsType = PatientAttribute(7L, "PreliminaryDiagnosis.SymptomsType", "string")

    PatientAttributesResource(List(pulmonaryEdema, dyspnoea, orthopnea, valSE, essentialSymptoms, symptomsType))
  }

}
