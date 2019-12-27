// Build level default settings
ThisBuild / name := "Advent of Code"
ThisBuild / version := "0.1.0"
ThisBuild / scalaVersion := "2.12.10"

// Library dependencies
lazy val versions = new {
  val scalatest = "3.1.0"
}

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % versions.scalatest % Test
)
