import sbt._

object Dependencies {

  val CswDeploy = Seq(
    TMT.`csw-framework`,
    TMT.`vslice`,
    Libs.`scalatest` % Test
  )

}
