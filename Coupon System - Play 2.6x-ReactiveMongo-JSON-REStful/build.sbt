name := """CouponSystemFinal"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.3"

//Dependency Injection
libraryDependencies += guice

//Fully featured http client for Scala which wraps java.net.HttpURLConnection
libraryDependencies += "org.scalaj" %% "scalaj-http" % "2.3.0"

//Provide simple toJson() and fromJson() methods to convert Java objects to JSON and vice-versa
libraryDependencies += "com.google.code.gson" % "gson" % "2.8.2"

//Project supporting MongoDB with Scala PlayFRAMEWORK 2.6.X
libraryDependencies += "org.reactivemongo" %% "play2-reactivemongo" % "0.12.7-play26"


