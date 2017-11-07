addSbtPlugin("com.geirsson"                      % "sbt-scalafmt"           % "1.3.0")
addSbtPlugin("org.foundweekends"                 % "sbt-bintray"            % "0.5.1")
addSbtPlugin("com.typesafe.sbt"                  % "sbt-native-packager"    % "1.2.2")
addSbtPlugin("com.eed3si9n"                      % "sbt-buildinfo"          % "0.7.0")

addSbtPlugin("io.get-coursier" % "sbt-coursier" % "1.0.0-RC13")
classpathTypes += "maven-plugin"

libraryDependencies += "com.trueaccord.scalapb" %% "compilerplugin" % "0.6.6"

scalacOptions ++= Seq(
  "-encoding",
  "UTF-8",
  "-feature",
  "-unchecked",
  "-deprecation",
  //"-Xfatal-warnings",
  "-Xlint",
  "-Yno-adapted-args",
  "-Ywarn-dead-code",
  "-Xfuture"
)
