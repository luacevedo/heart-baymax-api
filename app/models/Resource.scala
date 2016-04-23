package models

import play.api.libs.json.JsNull

trait Resource {
  val json = JsNull
}

