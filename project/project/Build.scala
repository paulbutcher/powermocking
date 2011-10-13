import sbt._
object PluginDef extends Build {
	override lazy val projects = Seq(root)
	lazy val root = Project("plugins", file(".")) dependsOn(borachioPlugin)
	lazy val borachioPlugin = file("/Users/paul/scala/borachio-sbt-plugin")
}