package mock

import models.{FieldValue, InputField, StepInputFields, PreliminaryDiagnosisFieldsResource}

object MockPatientInputFields {

  def getMockedPreliminaryDiagnosisFields(): PreliminaryDiagnosisFieldsResource = {

    val values = List(FieldValue("0", "No"), FieldValue("1", "Si"))

    val pulmonaryEdemaField = InputField(1, "Presenta edema pulmonar?", "EssentialSymptoms.PulmonaryEdema", "boolean", "combobox", values)
    val orthopneaField = InputField(2, "Presenta ortopnea?", "EssentialSymptoms.Orthopnoea", "boolean", "combobox", values)
    val dyspnoeaField  = InputField(3, "Presenta disnea?", "EssentialSymptoms.Dyspnoea", "boolean", "combobox", values)
    val lowerLimbEdemaField = InputField(4, "Presenta edema de miembros inferiores?", "EssentialSymptoms.LowerLimbEdema", "boolean", "combobox", values)

    val step1 = StepInputFields(1, List(pulmonaryEdemaField, orthopneaField))
    val step2 = StepInputFields(2, List(dyspnoeaField, lowerLimbEdemaField))

    PreliminaryDiagnosisFieldsResource(List(step1, step2))

  }

}