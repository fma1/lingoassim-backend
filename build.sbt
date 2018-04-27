import sbt._

import scalariform.formatter.preferences._

seq(Revolver.settings: _*)


/* scala versions and options */
scalaVersion := "2.11.7"

// These options will be used for *all* versions.
scalacOptions ++= Seq(
  "-deprecation"
  , "-unchecked"
  , "-encoding", "UTF-8"
  , "-Xlint"
  , "-Yclosure-elim"
  , "-Yinline"
  , "-Xverify"
  , "-feature"
  , "-language:postfixOps"
  //,"-optimise"
)

javacOptions ++= Seq("-Xlint:unchecked", "-Xlint:deprecation", "-source", "1.7", "-target", "1.7")
javaOptions in Universal ++= Seq(
  "-J-server",
  "-J-Xms3g -Xmx3g",
  "-J-XX:+UseConcMarkSweepGC -XX:+CMSParallelRemarkEnabled",
  "-J-XX:+UseCMSInitiatingOccupancyOnly -XX:CMSInitiatingOccupancyFraction=68",
  "-J-XX:+ScavengeBeforeFullGC -XX:+CMSScavengeBeforeRemark",
  "-J-XX:+UseGCLogFileRotation -XX:NumberOfGCLogFiles=10 -XX:GCLogFileSize=100M",
  "-Dorg.slf4j.simpleLogger.log.sorm=debug"
)

val FinchVersion = "0.14.1"
val CirceVersion = "0.7.1"

libraryDependencies ++= Seq(
  // -- config
  "com.typesafe" % "config" % "1.3.1",
  // -- testing --
  "org.scalacheck" %% "scalacheck" % "1.13.4" % "test",
  // -- Logging --
  "ch.qos.logback" % "logback-classic" % "1.1.3",
  "com.typesafe.scala-logging" %% "scala-logging" % "3.1.0",
  // -- Joda --
  "joda-time" % "joda-time" % "2.9.6",
  // -- Finch --
  "com.github.finagle" %% "finch-core" % FinchVersion,
  "com.github.finagle" %% "finch-circe" % FinchVersion,
  // -- json/circe --
  "io.circe" %% "circe-core" % CirceVersion,
  "io.circe" %% "circe-generic" % CirceVersion,
  "io.circe" %% "circe-jawn" % CirceVersion,
  // Google Cloud libraries
  "com.google.cloud" % "google-cloud-translate" % "1.26.0",
  // SORM
  "org.sorm-framework" % "sorm" % "0.3.21",
  "postgresql" % "postgresql" % "9.1-901-1.jdbc4",
  "com.google.api-client" % "google-api-client" % "1.23.0",
  "com.google.api-client" % "google-api-client-java6" % "1.23.0",
  "com.google.oauth-client" % "google-oauth-client" % "1.23.0",
  "com.google.oauth-client" % "google-oauth-client-jetty" % "1.23.0",
  "com.google.apis" % "google-api-services-oauth2" % "v2-rev131-1.23.0",
  "com.google.api.client" % "google-api-client-javanet" % "1.2.3-alpha",
  "com.google.http-client" % "google-http-client" % "1.23.0",
  "com.google.http-client" % "google-http-client-jackson2" % "1.23.0",
  "com.google.api.client" % "google-api-client-json" % "1.2.3-alpha"
)

fork := true

ivyScala := ivyScala.value map { _.copy(overrideScalaVersion = true) }

initialCommands in console := "import scalaz._, Scalaz._"

resolvers ++= Seq(
  "TM" at "http://maven.twttr.com",
  "Typesafe Snapshots" at "http://repo.typesafe.com/typesafe/snapshots/",
  "Secured Central Repository" at "https://repo1.maven.org/maven2",
  Resolver.sonatypeRepo("snapshots")
)

// scalariform
scalariformSettings

ScalariformKeys.preferences := ScalariformKeys.preferences.value
  .setPreference(AlignSingleLineCaseStatements, true)
  .setPreference(DoubleIndentClassDeclaration, true)
  .setPreference(IndentLocalDefs, true)
  .setPreference(IndentPackageBlocks, true)
  .setPreference(IndentSpaces, 2)
  .setPreference(MultilineScaladocCommentsStartOnFirstLine, false)

