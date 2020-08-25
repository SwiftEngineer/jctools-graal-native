# jctools-graal-native

This library contains substitutions for various bits of code in [JCTools](https://github.com/JCTools/JCTools) that normally cannot be compiled by Graal's SubstrateVM. These substitutions are only used at compile time, so be sure to only include them in your project's `provided` scope.

You only need this library if your project or one of it's dependencies actually use one of the substituted classes (graal should log warnings during compilation).

# Usage

#### sbt

```sbt
// Contains substitutions that are necessary for native image creation. These substitutions are required since monix
// depends on JCTools which contains a lot of code that can't be compiled by graal native.
libraryDependencies ++= Seq(
  "science.doing" % "jctools-graal-native" % "1.0.0" % Provided,
  "com.oracle.substratevm" % "svm" % "19.2.1" % Provided
)
```

#### Gradle

```groovy
// Contains substitutions that are necessary for native image creation. These substitutions are required since monix
// depends on JCTools which contains a lot of code that can't be compiled by graal native.
compileOnly "science.doing:jctools-graal-native:1.0.0"
compileOnly "com.oracle.substratevm:svm:19.2.1"
```

