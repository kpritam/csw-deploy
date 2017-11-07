
lazy val aggregatedProjects: Seq[ProjectReference] = Seq(
  `csw-deploy`
)

lazy val `csw-deploy` = project
  .enablePlugins(DeployApp)
  .settings(
    libraryDependencies ++= Dependencies.CswDeploy
  )
