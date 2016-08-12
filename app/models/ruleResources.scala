package models

import models.writes.RuleWrites
import play.api.libs.json.{JsValue, Json}

case class RulesResponse(rules: List[RuleResource]) extends Resource with RuleWrites {
  override def getJson(): JsValue = Json.toJson(rules)
}
case class RuleResource(id: Int, conditions: List[Condition], actions: List[Action], rulesToExclude: List[RuleToExclude])

case class Rule(id: Int, name: String)

case class Condition(id: Int, cType: String, attribute: String, value: Option[String], ruleId: Int)

case class Action(id: Int, actionFunction: String, attribute: String, value: String, ruleId: Int)

case class RuleToExclude(id: Int, ruleId: Int)