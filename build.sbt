import sbt._

lazy val root = (project in file("."))
  .settings(
    name := "jctools-graal-native",
    version := "1.0.0"
  )
  .settings(
    // don't include the scala library
    autoScalaLibrary := false,
    crossPaths := false,

    // Used to define the substitutions that are necessary for native image creation
    libraryDependencies += "com.oracle.substratevm" % "svm" % "19.2.1" % Provided,
  )


/**
 * Publishing information
 *
 * In order to publish, follow the steps at https://www.scala-sbt.org/release/docs/Using-Sonatype.html
 *
 */

ThisBuild / organization := "science.doing"
ThisBuild / organizationName := "SwiftEngineer"
ThisBuild / organizationHomepage := Some(url("https://im.doing.science/"))
ThisBuild / developers := List(
  Developer(
    id    = "SwiftEngineer",
    name  = "Taylor Brooks",
    email = "harbinzerg@gmail.com",
    url   = url("https://im.doing.science")
  )
)

ThisBuild / scmInfo := Some(
  ScmInfo(
    url("https://github.com/SwiftEngineer/jctools-graal-native"),
    "scm:git@github.com:SwiftEngineer/jctools-graal-native.git"
  )
)

ThisBuild / useGpg := true

ThisBuild / description := "Substitutions required for building graal native images from code that relies on JCTools"
ThisBuild / licenses := List("Apache 2" -> new URL("http://www.apache.org/licenses/LICENSE-2.0.txt"))
ThisBuild / homepage := Some(url("https://github.com/SwiftEngineer/jctools-graal-native"))
ThisBuild / organizationHomepage := Some(url("https://im.doing.science/"))

// Remove all additional repository other than Maven Central from POM
ThisBuild / pomIncludeRepository := { _ => false }
ThisBuild / publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value) Some("snapshots" at nexus + "content/repositories/snapshots")
  else Some("releases" at nexus + "service/local/staging/deploy/maven2")
}
ThisBuild / publishMavenStyle := true