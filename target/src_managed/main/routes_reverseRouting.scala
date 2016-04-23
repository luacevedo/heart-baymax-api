// @SOURCE:/Users/luacevedo/workspace/heart-baymax-api/conf/routes
// @HASH:61fbd44456d07ed5a3d1d476be6a77305410ba42
// @DATE:Mon Apr 18 23:00:35 ART 2016

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset

import Router.queryString


// @LINE:9
// @LINE:6
package controllers {

// @LINE:9
class ReverseRulesController {
    

// @LINE:9
def getRules(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "rules")
}
                        
    
}
                          

// @LINE:6
class ReverseApplication {
    

// @LINE:6
def index(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix)
}
                        
    
}
                          
}
                  


// @LINE:9
// @LINE:6
package controllers.javascript {
import ReverseRouteContext.empty

// @LINE:9
class ReverseRulesController {
    

// @LINE:9
def getRules : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RulesController.getRules",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rules"})
      }
   """
)
                        
    
}
              

// @LINE:6
class ReverseApplication {
    

// @LINE:6
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        
    
}
              
}
        


// @LINE:9
// @LINE:6
package controllers.ref {


// @LINE:9
class ReverseRulesController {
    

// @LINE:9
def getRules(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.RulesController.getRules(), HandlerDef(this.getClass.getClassLoader, "", "controllers.RulesController", "getRules", Seq(), "GET", """ Rules""", _prefix + """rules""")
)
                      
    
}
                          

// @LINE:6
class ReverseApplication {
    

// @LINE:6
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "index", Seq(), "GET", """ Home page""", _prefix + """""")
)
                      
    
}
                          
}
        
    