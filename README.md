# jctools-graal-native

This library contains substitutions for various bits of code in [JCTools](https://github.com/JCTools/JCTools) that normally cannot be compiled by Graal's SubstrateVM. These substitutions are only used at compile time, so be sure to only include them in your project's `provided` scope.

You only need this library if your project or one of it's dependencies actually use one of the substituted classes (graal should log warnings during compilation).