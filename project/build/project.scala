import sbt._

class PowerMocking(info: ProjectInfo) extends DefaultProject(info) with GenerateMocks {
  val scalatest = "org.scalatest" %% "scalatest" % "1.6.1"

  val scalaToolsSnapshots = ScalaToolsSnapshots
  val borachio_library = "com.borachio" %% "library" % "2.0-SNAPSHOT"
  val borachio_plugin = "com.borachio" %% "compiler-plugin" % "2.0-SNAPSHOT"
}
