name := "shapes-oo-scala"

version := "0.5"

libraryDependencies ++= Seq(
  "org.creativescala"    %% "doodle"            % "0.34.0",
  "org.log4s"            %% "log4s"             % "1.10.0",
  "org.slf4j"            %  "slf4j-simple"      % "1.7.30",
  "com.github.sbt.junit" %  "jupiter-interface" % JupiterKeys.jupiterVersion.value % Test
)
