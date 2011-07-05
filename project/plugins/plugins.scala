import sbt._

class Plugins(info: ProjectInfo) extends PluginDefinition(info) {
  
  val scalaToolsSnapshots = ScalaToolsSnapshots
  val borachio = "com.borachio" % "sbt-plugin" % "2.0-SNAPSHOT"
}
