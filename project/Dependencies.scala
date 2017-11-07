import sbt._

object Dependencies {

  val CswDeploy = Seq(
    TMT.`csw-framework`,
    TMT.`csw-vslice`,
    Libs.`scalatest` % Test
  )

}
