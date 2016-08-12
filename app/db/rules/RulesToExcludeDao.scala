package db.rules

import models.{RuleToExclude, Condition}
import slick.driver.PostgresDriver.api._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

class RulesToExclude(tag: Tag) extends Table[RuleToExclude](tag, "CONDITIONS") {
  def id = column[Int]("ID", O.PrimaryKey, O.AutoInc)

  def ruleId = column[Int]("RULE_ID")

  def rule = foreignKey("RULE_FK", ruleId, TableQuery[Rules])(_.id, onUpdate=ForeignKeyAction.Restrict, onDelete=ForeignKeyAction.Cascade)

  def * = (id, ruleId) <>((RuleToExclude.apply _).tupled, RuleToExclude.unapply)

}

object RulesToExcludeDAO extends TableQuery(new RulesToExclude(_)) {

  val db = Database.forConfig("database")

  val rulesToExclude = TableQuery[RulesToExclude]

  def filterQuery(id: Int): Query[RulesToExclude, RuleToExclude, Seq] =
    rulesToExclude.filter(_.id === id)

  def findById(id: Int): Future[Option[RuleToExclude]] =
    try db.run(this.filter(_.id === id).result).map(_.headOption)
    finally db.close

  def insert(ruleToExclude: RuleToExclude): Future[Int] =
    try db.run(rulesToExclude += ruleToExclude)
    finally db.close

  def updateById(id: Int, ruleToExclude: RuleToExclude): Future[Int] =
    try db.run(filterQuery(id).update(ruleToExclude))
    finally db.close

  def deleteById(id: Int): Future[Int] =
    try db.run(filterQuery(id).delete)
    finally db.close

}

