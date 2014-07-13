logLevel := Level.Warn

addSbtPlugin("codes.reactive.sbt" % "sbt-codes" % "0.2.0-SNAPSHOT")

addSbtPlugin("org.scalastyle" %% "scalastyle-sbt-plugin" % "0.4.0")

addSbtPlugin("com.typesafe.sbt" % "sbt-ghpages" % "0.5.3")

addSbtPlugin("com.typesafe.sbt" % "sbt-site" % "0.8.1")

resolvers += Resolver.sonatypeRepo("snapshots")