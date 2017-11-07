import sbt._
import com.trueaccord.scalapb.compiler.Version.scalapbVersion

object Libs {
  val ScalaVersion = "2.12.4"

  val `scalatest` = "org.scalatest" %% "scalatest" % "3.0.4" //Apache License 2.0
}

object TMT {
  val Version = "0.1.2+951-e63f6d80"

  val `csw-framework` = "org.tmt" %% "csw-framework" % Version
  val `vslice` = "org.tmt" %% "csw-vslice" % Version
}
