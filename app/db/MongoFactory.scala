package db

import org.mongodb.scala._

object MongoFactory {
  private val SERVER = "localhost"
  private val PORT   = 27017
  private val DATABASE = "mytestdb"

  val mongoClient: MongoClient = MongoClient()

  val database: MongoDatabase = mongoClient.getDatabase(DATABASE)

  def printDatabases() = {
    mongoClient.listDatabaseNames().subscribe(new Observer[String] {

      override def onError(e: Throwable): Unit = println("error "+e.toString)

      override def onComplete(): Unit = println("completed")

      override def onNext(result: String): Unit = println(result)
    })

  }

  def getCollection(collectionName: String) = {
      database.getCollection(collectionName)
  }

}
