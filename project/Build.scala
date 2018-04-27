import sbt._
import sbt.Keys._

object LingolearnerBuild extends Build {

  lazy val lingolearner = Project(
    id = "lingolearner",
    base = file("."),
    settings = Project.defaultSettings ++ Seq(
      name := "lingolearner",
      organization := "org.example",
      version := "0.1-SNAPSHOT",
      scalaVersion := "2.12.2"
      // add other settings here
    )
  )
}
