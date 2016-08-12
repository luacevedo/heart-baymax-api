package db.rules

import models.Action
import slick.driver.PostgresDriver.api._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future


class Actions(tag: Tag) extends Table[Action](tag, "ACTIONS") {
  def id = column[Int]("ID", O.PrimaryKey, O.AutoInc)

  def actionFunction = column[String]("ACTION_FUNCTION")

  def attribute = column[String]("ATTRIBUTE")

  def value = column[String]("VALUE")

  def ruleId = column[Int]("RULE_ID")

  def rule = foreignKey("RULE_FK", ruleId, TableQuery[Rules])(_.id, onUpdate=ForeignKeyAction.Restrict, onDelete=ForeignKeyAction.Cascade)

  def * = (id, actionFunction, attribute, value, ruleId) <>((Action.apply _).tupled, Action.unapply)

}

object ActionsDAO extends TableQuery(new Actions(_)) {

  val db = Database.forConfig("database")

  val actions = TableQuery[Actions]

  def filterQuery(id: Int): Query[Actions, Action, Seq] =
    actions.filter(_.id === id)

  def findById(id: Int): Future[Option[Action]] =
    try db.run(this.filter(_.id === id).result).map(_.headOption)
    finally db.close

  def insert(action: Action): Future[Int] =
    try db.run(actions += action)
    finally db.close

  def updateById(id: Int, action: Action): Future[Int] =
    try db.run(filterQuery(id).update(action))
    finally db.close

  def deleteById(id: Int): Future[Int] =
    try db.run(filterQuery(id).delete)
    finally db.close

}

