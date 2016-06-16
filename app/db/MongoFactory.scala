package db

import org.mongodb.scala._

object MongoFactory {
  private val SERVER = "localhost"
  private val PORT   = 27017
  private val DATABASE = "test1"

  val mongoClient: MongoClient = MongoClient("mongodb://heroku_1hl7j974:4fnvqu7l22qpbkjbbqgkhsmd3e@ds015924.mlab.com:15924/heroku_1hl7j974?authMode=scram-sha1")

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
