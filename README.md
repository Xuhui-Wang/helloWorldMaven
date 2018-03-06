[![Build Status](https://travis-ci.org/Xuhui-Wang/helloWorldMaven.svg?branch=master)](https://travis-ci.org/Xuhui-Wang/helloWorldMaven)

# Hello, Maven!
This is an experimental repository to manage Spring boot projects using Maven.

---
## Spring IoC container and beans
IoC is also known as dependency injection (DI). It is a process whereby objects define their dependencies, that is, the other objects they work with, only through constructor arguments, arguments to a factory method, or properties that are set on the object instance after it is constructed or returned from a factory method. The container then injects those dependencies when it creates the bean. This process is fundamentally the inverse, hence the name Inversion of Control (IoC), of the bean itself controlling the instantiation or location of its dependencies by using direct construction of classes, or a mechanism such as the Service Locator pattern.

---
## Annotation-based container configuration in practice
Annotation-based configurations v.s. XML:

Due to the way they are defined, annotations provide a lot of context in their declaration, leading to shorter and more concise configuration. However, XML excels at wiring up components without touching their source code or recompiling them. Some developers prefer having the wiring close to the source while others argue that annotated classes are no longer POJOs and, furthermore, that the configuration becomes decentralized and harder to control.
