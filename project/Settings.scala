import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport._
import sbt._

object Settings {

  val name = "Example"

  val scalacOptions = Seq(
    "-Xlint",
    "-unchecked",
    "-deprecation",
    "-feature"
  )

  object versions {
    val scala = "2.12.2"

    // libraryDependencies
    val scalaJsReact = "1.0.1"
    val diode = "1.1.2"

    // libraryDependencies (test)
    val scalaTest = "3.0.1"

    // jsDependencies
    val react = "15.5.4"
  }

  val libraryDependencies = Def.setting(Seq(

    "com.github.japgolly.scalajs-react" %%% "core" % versions.scalaJsReact,
    "io.suzaku" %%% "diode" % versions.diode,
    "io.suzaku" %%% "diode-react" % versions.diode,

    // test
    "org.scalatest" %%% "scalatest" % versions.scalaTest % "test"
  ))

  val jsDependencies = Def.setting(Seq(
    "org.webjars.bower" % "react" % versions.react / "react-with-addons.js" minified "react-with-addons.min.js" commonJSName "React",
    "org.webjars.bower" % "react" % versions.react / "react-dom.js" minified "react-dom.min.js" dependsOn "react-with-addons.js" commonJSName "ReactDOM",
    RuntimeDOM % "test"
  ))

}
