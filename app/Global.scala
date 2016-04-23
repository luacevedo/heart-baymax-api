import play.api._
import play.api.mvc.Results._
import play.api.mvc._
import scala.concurrent._
import ExecutionContext.Implicits.global

object Global extends GlobalSettings {

  override def onError(request: RequestHeader, ex: Throwable) = Future {
    Logger.error(
      "Heart Baymax API Internal Error!\n"+
      "Request: "+request.toString+", "+
      "Remote IP:"+request.remoteAddress+", "+
      "Domain:"+request.domain+" host:"+request.host+", "+
      "Accept Languages:"+request.acceptLanguages.mkString(",")+"\n"+
      "Exception"+ex.getMessage+"\n"
    )
    InternalServerError("Heart Baymax API Internal Error!").withHeaders(
      Seq("Cache-Control" -> "no-cache,max-age=0", "Edge-Control" -> "!no-store,max-age=0s"):_*
    )
  }

  override def onHandlerNotFound(request: RequestHeader) = Future {
    NotFound("Route not found: " + request.path).withHeaders(
      Seq("Cache-Control" -> "max-age=120", "Edge-Control" -> "!no-store,max-age=120s" ):_*)
  }

}

