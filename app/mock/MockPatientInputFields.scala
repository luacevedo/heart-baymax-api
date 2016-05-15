package mock

import models.{FieldValue, InputField, StepInputFields, PreliminaryDiagnosisFieldsResource}

object MockPatientInputFields {

  def getMockedPreliminaryDiagnosisFields(): PreliminaryDiagnosisFieldsResource = {

    val values = List(FieldValue("1", "Si"), FieldValue("2", "No"))

    val pulmonaryEdemaField = InputField(1, "Presenta edema pulmonar?", "EssentialSymptoms.PulmonaryEdema", "select", "combobox", values)
    val orthopneaField = InputField(2, "Presenta ortopnea?", "EssentialSymptoms.Orthopnoea", "select", "combobox", values)
    val dyspnoeaField = InputField(3, "Presenta disnea?", "EssentialSymptoms.Dyspnoea", "select", "combobox", values)

    val step1 = StepInputFields(1, List(pulmonaryEdemaField, orthopneaField))
    val step2 = StepInputFields(2, List(dyspnoeaField))

    PreliminaryDiagnosisFieldsResource(List(step1, step2))

  }

}