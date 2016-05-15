package models.writes

import models._
import play.api.libs.json._
import play.api.libs.functional.syntax._

trait PatientAttributesWrites {

  implicit val patientAttributesWrites: Writes[PatientAttribute] = (
    (JsPath \ "id").write[Long] and
    (JsPath \ "root").write[String] and
    (JsPath \ "dataType").write[String]
   )(unlift(PatientAttribute.unapply))

}
