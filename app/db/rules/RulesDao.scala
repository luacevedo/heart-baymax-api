package db.rules

import models.{Rule, Condition}
import slick.driver.PostgresDriver.api._
import slick.lifted.ProvenShape

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future


class Rules(tag: Tag) extends Table[Rule](tag, "RULES") {
  def id = column[Int]("ID", O.PrimaryKey, O.AutoInc)

  def name = column[String]("NAME")

  def * = (id, name) <>((Rule.apply _).tupled, Rule.unapply)
}
//
//
//
//object RulesDAO extends TableQuery(new Rules(_)) {
//
//  val db = Database.forConfig("database")
//
//  val rules = TableQuery[Rules]
//
//  def filterQuery(id: Int): Query[Rules, Rule, Seq] =
//    rules.filter(_.id === id)
//
//  def findById(id: Int): Future[Option[Rule]] =
//    try db.run(this.filter(_.id === id).result).map(_.headOption)
//    finally db.close
//
//  def insert(rule: Rule): Future[Int] =
//    try db.run(rules += rule)
//    finally db.close
//
//  def updateById(id: Int, rule: Rule): Future[Int] =
//    try db.run(filterQuery(id).update(rule))
//    finally db.close
//
//  def deleteById(id: Int): Future[Int] =
//    try db.run(filterQuery(id).delete)
//    finally db.close
//
//}

