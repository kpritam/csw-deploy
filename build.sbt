
lazy val aggregatedProjects: Seq[ProjectReference] = Seq(
  `csw-nfiraos`,
  `csw-iris`
)

lazy val `csw-deploy` = project
  .in(file("."))
  .aggregate(aggregatedProjects: _*)

lazy val `csw-nfiraos` = project
  .enablePlugins(DeployApp)
  .settings(
    libraryDependencies ++= Dependencies.NFIRAOS
  )

lazy val `csw-iris` = project
  .enablePlugins(DeployApp)
  .settings(
    libraryDependencies ++= Dependencies.IRIS
  )
