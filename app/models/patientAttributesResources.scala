package models

import models.writes.{PatientAttributesWrites, PatientInputFieldsWrites}
import play.api.libs.json.{Json, JsValue}

case class PatientAttributesResource(attributes: List[PatientAttribute]) extends Resource with PatientAttributesWrites {
  override def getJson(): JsValue = Json.toJson(attributes)
}

case class PatientAttribute(id: Long, root: String, dataType: String)
