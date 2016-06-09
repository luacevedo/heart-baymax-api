package models

import models.writes.PatientInputFieldsWrites
import play.api.libs.json.{Json, JsValue}

case class PreliminaryDiagnosisFieldsResource(stepInputFields: List[StepInputFields]) extends Resource with PatientInputFieldsWrites {
  override def getJson(): JsValue = Json.toJson(stepInputFields)
}

case class StepInputFields(step: Double, inputFields: List[InputField])
case class InputField(id: Long, labelMessage: String, rootToAffect: String, dataType: String, fieldType: String, values: List[FieldValue])
case class FieldValue(key: String, value: String)