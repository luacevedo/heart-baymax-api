package models.writes

import models._
import play.api.libs.functional.syntax._
import play.api.libs.json._

trait RuleWrites {

  implicit val conditionWrites: Writes[Condition] = new Writes[Condition] {
    def writes(condition: Condition): JsValue = {
      Json.obj(
        "type" -> condition.cType,
        "attribute" -> condition.attribute,
        "value" -> condition.value)
    }
  }

  implicit val actionWrites: Writes[Action] = new Writes[Action] {
    def writes(action: Action): JsValue = {
      Json.obj(
        "function" -> action.actionFunction,
        "attribute" -> action.attribute,
        "value" -> action.value)
    }
  }

  implicit val ruleWrites: Writes[RuleResource] = new Writes[RuleResource] {
    def writes(rule: RuleResource): JsValue = {
      val rulesToExclude: List[Int] = rule.rulesToExclude.map(i => i.id)
      Json.obj(
        "id" -> rule.id,
        "conditions" -> rule.conditions,
        "actions" -> rule.actions,
        "rulesToExclude" -> rulesToExclude)
    }
  }

}
