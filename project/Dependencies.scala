import sbt._

object Dependencies {

  val NFIRAOS = Seq(
    TMT.`nfiraos-subsystem`,
    Libs.`scalatest` % Test
  )

  val IRIS = Seq(
    TMT.`iris-subsystem`,
    Libs.`scalatest` % Test
  )
}
