// Sbt plugins
lazy val versions = new {
  val dependencyGraph = "0.9.0"
  val scalastyle = "1.0.0"
  val scoverage = "1.5.1"
}
addSbtPlugin("net.virtual-void"    % "sbt-dependency-graph"     % versions.dependencyGraph)
addSbtPlugin("org.scalastyle"     %% "scalastyle-sbt-plugin"    % versions.scalastyle)
addSbtPlugin("org.scoverage"      %% "sbt-scoverage"            % versions.scoverage)
