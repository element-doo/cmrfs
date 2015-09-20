name := "cmrfs"
organization := "hr.element.cmrfs"
version := "0.1.1"

libraryDependencies ++= Seq(
  "org.scala-lang.modules" %% "scala-swing" % "2.0.0-M2"
, "com.github.scala-incubator.io" %% "scala-io-file" % "0.4.3-1"
, "com.typesafe.scala-logging" %% "scala-logging" % "3.1.0"
, "ch.qos.logback" % "logback-classic" % "1.1.3"
)

unmanagedSourceDirectories in Compile := (scalaSource in Compile).value :: Nil
unmanagedResourceDirectories in Compile := (resourceDirectory in Compile).value :: Nil
unmanagedSourceDirectories in Test := Nil
unmanagedResourceDirectories in Test := Nil

scalaVersion := "2.11.7"
scalacOptions := Seq(
  "-deprecation"
, "-encoding", "UTF-8"
, "-feature"
, "-language:existentials"
, "-language:implicitConversions"
, "-language:postfixOps"
, "-language:reflectiveCalls"
, "-optimise"
, "-unchecked"
, "-Xcheckinit"
, "-Xlint"
, "-Xmax-classfile-name", "72"
, "-Xno-forwarders"
, "-Xverify"
, "-Yclosure-elim"
, "-Yconst-opt"
, "-Ydead-code"
, "-Yinline-warnings"
, "-Yinline"
, "-Yrepl-sync"
, "-Ywarn-adapted-args"
, "-Ywarn-dead-code"
, "-Ywarn-inaccessible"
, "-Ywarn-infer-any"
, "-Ywarn-nullary-override"
, "-Ywarn-nullary-unit"
, "-Ywarn-numeric-widen"
, "-Ywarn-unused"
)
