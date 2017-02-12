lazy val root = (project in file("."))
  .enablePlugins(ScalaJSPlugin)
  .settings(
    name := Settings.name,
    scalaVersion := Settings.versions.scala,
    scalacOptions ++= Settings.scalacOptions
  )

// dependencies needed by Scala.js
libraryDependencies ++= Settings.libraryDependencies.value

// JS dependencies needed at runtime
jsDependencies ++= Settings.jsDependencies.value

// yes, we want to package JS dependencies
skip in packageJSDependencies := false

// use launcher code to start the client app (see launcher.js in index.html)
persistLauncher := true
persistLauncher in Test := false

// make the referenced paths on source maps relative to target path
relativeSourceMaps := true
