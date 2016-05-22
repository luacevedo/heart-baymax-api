import play.Play.autoImport._
import sbt.Keys._
import sbt._

object ApplicationBuild extends Build {

  val appName = "heart-baymax-api"

  def normalArtifact(config: sbt.ScalaVersion, module: ModuleID, artifact: Artifact) = artifact.name + module.revision + "." + artifact.extension

  val appDependencies: Seq[sbt.ModuleID] = Seq(
    cache,
    ws,
    // "org.mockito" % "mockito-all" % "1.9.0",
    // "com.github.mumoshu" %% "play2-memcached" % "0.6.0",
    // "net.debasishg" %% "redisclient" % "2.13",
    "org.apache.httpcomponents" % "httpclient" % "4.2.5",
    "org.mongodb.scala" %% "mongo-scala-driver" % "1.1.1",
    "org.apache.httpcomponents" % "httpmime" % "4.2.5",
     "io.reactivex" %% "rxscala" % "0.23.0")
  // "com.github.tototoshi" %% "scala-csv" % "1.0.0")

  // val showTestOutput = scala.util.Properties.envOrElse("HB_API_TEST_STDOUT", "false") == "true"

  lazy val main = Project("heart-baymax-api", file(".")).enablePlugins(play.PlayScala)
    .settings(
      name := "heart-baymax-api",

      artifactName := normalArtifact,

      version := "1.0.0",

      // disable publishing the main jar produced by `package`
      // publishArtifact in Test := false,

      // // disable publishing the main API jar
      // publishArtifact in (Compile, packageDoc) := false,

      // // disable publishing the main sources jar
      // publishArtifact in (Compile, packageSrc) := false,
      // crossPaths := false,


      scalacOptions ++= Seq("-feature"),

      javaOptions ++= Seq("-Xms512M", "-Xmx2048M", "-XX:MaxPermSize=2048M", "-XX:+CMSClassUnloadingEnabled"),

      scalaVersion := "2.11.8",

      resolvers := Seq(
        "Sonatype OSS Snapshots Repository" at "http://oss.sonatype.org/content/groups/public",
        "Local Maven Repository" at "file://" + Path.userHome.absolutePath + "/.m2/repository",
        "sonatype-snapshots" at "https://oss.sonatype.org/content/repositories/snapshots",
        "sonatype-releases" at "https://oss.sonatype.org/content/repositories/releases",
        "java-net" at "http://download.java.net/maven/2",
        "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"),
      // "Spy Repository" at "http://files.couchbase.com/maven2",
      // "RoundEights" at "http://maven.spikemark.net/roundeights"),

      libraryDependencies ++= appDependencies // required to resolve `spymemcached`, the plugin's dependency.
    )

  override def rootProject = Some(main)

}
