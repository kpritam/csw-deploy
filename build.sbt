
lazy val aggregatedProjects: Seq[ProjectReference] = Seq(
  `csw-nfiraos`,
  `csw-iris`
)

lazy val `csw-deploy` = project
  .in(file("."))
    .enablePlugins(SbtGithubReleasePlugin)
    .settings(
      ghreleaseRepoName := "csw-deploy",
      ghreleaseAssets := Seq(
        (packageBin in Universal in `csw-nfiraos`).value,
        (packageBin in Universal in `csw-iris`).value
      )

    )
  .aggregate(aggregatedProjects: _*)

lazy val `csw-nfiraos` = project
  .enablePlugins(DeployApp)
  .settings(
    libraryDependencies ++= NFIRAOS.components
  )

lazy val `csw-iris` = project
  .enablePlugins(DeployApp)
  .settings(
    libraryDependencies ++= IRIS.components
  )
