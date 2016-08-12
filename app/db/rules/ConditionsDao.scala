package db.rules

import models.Condition
import slick.driver.PostgresDriver.api._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future


class Conditions(tag: Tag) extends Table[Condition](tag, "CONDITIONS") {
  def id = column[Int]("ID", O.PrimaryKey, O.AutoInc)

  def cType = column[String]("CONDITION_TYPE")

  def attribute = column[String]("ATTRIBUTE")

  def value = column[String]("VALUE")

  def ruleId = column[Int]("RULE_ID")

  def rule = foreignKey("RULE_FK", ruleId, TableQuery[Rules])(_.id, onUpdate=ForeignKeyAction.Restrict, onDelete=ForeignKeyAction.Cascade)

  def * = (id, cType, attribute, value.?, ruleId) <>((Condition.apply _).tupled, Condition.unapply)

}

object ConditionsDAO extends TableQuery(new Conditions(_)) {

  val db = Database.forConfig("database")

  val conditions = TableQuery[Conditions]

  def filterQuery(id: Int): Query[Conditions, Condition, Seq] =
    conditions.filter(_.id === id)

  def findById(id: Int): Future[Option[Condition]] =
    try db.run(this.filter(_.id === id).result).map(_.headOption)
    finally db.close

  def insert(condition: Condition): Future[Int] =
    try db.run(conditions += condition)
    finally db.close

  def updateById(id: Int, condition: Condition): Future[Int] =
    try db.run(filterQuery(id).update(condition))
    finally db.close

  def deleteById(id: Int): Future[Int] =
    try db.run(filterQuery(id).delete)
    finally db.close

}

