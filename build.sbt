name := "shapes-oo-scala"

version := "0.5"

libraryDependencies ++= Seq(
  "org.creativescala"    %% "doodle"            % "0.34.0",
  "com.github.sbt.junit" %  "jupiter-interface" % JupiterKeys.jupiterVersion.value % Test
)
