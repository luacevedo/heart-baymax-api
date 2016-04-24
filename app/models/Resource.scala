package models

import play.api.libs.json.{JsValue}

trait Resource {
  def getJson(): JsValue
}

