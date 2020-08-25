# jctools-graal-native

This library contains substitutions for various bits of code in [JCTools](https://github.com/JCTools/JCTools) that normally cannot be compiled by Graal's SubstrateVM. These substitutions are only used at compile time, so be sure to only include them in your project's `provided` scope.

You only need this library if your project or one of it's dependencies actually use one of the substituted classes (graal should log warnings during compilation).

# Usage

**Disclaimer:** Currently, this project only works for version 20.2.0 of Graal. You can recompile this project with a different version of the `org.graalvm.nativeimage:svm` dependency. My goal is for future versions to be more flexible. 

#### sbt

```sbt
// Contains substitutions that are necessary for native image creation. These substitutions are required since JCTools
// contains a lot of code that can't be compiled by graal native.
libraryDependencies ++= Seq(
  "science.doing" % "jctools-graal-native_20_2_0" % "1.0.0",
  "org.graalvm.nativeimage" % "svm" % "20.2.0" % Provided
)
```

#### Gradle

```groovy
// Contains substitutions that are necessary for native image creation. These substitutions are required since JCTools
// contains a lot of code that can't be compiled by graal native.
compile "science.doing:jctools-graal-native_20_2_0:1.0.0"
compileOnly "org.graalvm.nativeimage:svm:20.2.0"
```

