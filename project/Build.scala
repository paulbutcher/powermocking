import sbt._
import Keys._
import BorachioPlugin._

object PowerMockingBuild extends Build {

  override lazy val settings = super.settings ++ Seq(
    organization := "com.paulbutcher",
    version := "2.0",
    scalaVersion := "2.9.0",
    scalacOptions ++= Seq("-deprecation", "-unchecked", "-Xfatal-warnings"),

    resolvers += ScalaToolsSnapshots,
    libraryDependencies += "com.borachio" %% "borachio-scalatest-support" % "2.0-SNAPSHOT",
    autoCompilerPlugins := true,
    addCompilerPlugin("com.borachio" %% "borachio-compiler-plugin" % "2.0-SNAPSHOT"))
    
  lazy val powermocking = Project("PowerMocking", file(".")) settings(generateMocksSettings: _*) configs(Mock)
}