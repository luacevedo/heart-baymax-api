package models

import models.writes.RuleWrites
import play.api.libs.json.{Json, JsValue}

case class Rule(id: Long, conditions: List[Condition], actions: List[Action], rulesToExclude: List[Long]) extends Resource with RuleWrites {
  override def getJson(): JsValue = Json.toJson(this)
}

case class Condition(cType: String, attribute: String, value: String)

case class Action(actionFunction: String, attribute: String, value: String)