

lazy val aggregatedProjects: Seq[ProjectReference] = Seq(
  `csw-nfiraos`,
  `csw-iris`
)

val coverageReportZipKey = TaskKey[File]("zip", "Creates a distributable zip file containing the coverage report.")

lazy val `csw-deploy` = project
  .in(file("."))
  .enablePlugins(SbtGithubReleasePlugin)
  .settings(
    coverageReportZipKey := {
      lazy val coverageReportZip = crossTarget.value / "scoverage-report.zip"
      IO.zip(Path.allSubpaths(crossTarget.value / "scoverage-report"), coverageReportZip)
      coverageReportZip
    },

    ghreleaseRepoName := "csw-deploy",
    ghreleaseAssets := Seq(
      (packageBin in Universal in `csw-nfiraos`).value,
      (packageBin in Universal in `csw-iris`).value,
      coverageReportZipKey.value
    ),
    aggregate in githubRelease := false
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
