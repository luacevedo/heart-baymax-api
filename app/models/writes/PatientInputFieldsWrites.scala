package models.writes

import models._
import play.api.libs.json._
import play.api.libs.functional.syntax._

trait PatientInputFieldsWrites {

  implicit val fieldValueWrites: Writes[FieldValue] = (
    (JsPath \ "key").write[String] and
    (JsPath \ "value").write[String]
   )(unlift(FieldValue.unapply))

  implicit val inputFieldWrites: Writes[InputField] = (
    (JsPath \ "id").write[Long] and
    (JsPath \ "labelMessage").write[String] and
    (JsPath \ "rootToAffect").write[String] and
    (JsPath \ "dataType").write[String] and
    (JsPath \ "fieldType").write[String] and
    (JsPath \ "values").write[List[FieldValue]]
   )(unlift(InputField.unapply))

  implicit val ruleWrites: Writes[StepInputFields] = (
    (JsPath \ "step").write[Double] and
    (JsPath \ "inputFields").write[List[InputField]]
   )(unlift(StepInputFields.unapply))

}
