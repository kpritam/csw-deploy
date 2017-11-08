import sbt._
import com.trueaccord.scalapb.compiler.Version.scalapbVersion

object Libs {
  val ScalaVersion = "2.12.4"

  val `scalatest` = "org.scalatest" %% "scalatest" % "3.0.4" //Apache License 2.0
}

object TMT {
  val `nfiraos-subsystem` = "org.tmt" %% "csw-vslice" % "0.1.2+964-3c3abb07"
  val `iris-subsystem`    = "org.tmt" %% "csw-vslice" % "0.1.2+964-3c3abb07"
}
