package controllers

import helpers.ObservableHelper
import models.Resource
import play.api.mvc._
import play.api.libs.concurrent.Execution.Implicits._

import scala.concurrent.Future

trait ResourcesController extends Controller {

  def MyAction[A](f: Request[AnyContent] => Future[Resource]): Action[AnyContent] = {
    Action.async { request =>
      f(request).map {
        resource => Ok(resource.getJson())
      }
    }
  }

}
