package models

import models.writes.RuleWrites
import play.api.libs.json.{Json, JsValue}

case class RulesResource(rules: List[Rule]) extends Resource with RuleWrites {
  override def getJson(): JsValue = Json.toJson(rules)
}

case class Rule(id: Long, conditions: List[Condition], actions: List[Action], rulesToExclude: List[Long])
case class Condition(cType: String, attribute: String, value: Option[String])
case class Action(actionFunction: String, attribute: String, value: String)