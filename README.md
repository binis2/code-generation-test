# code-generation-test

Mocking suite for Binis CodeGen Library.

### Introduction

Module to help writing unit tests for units that use Binis CodeGen library.

### Mocking creation

To use the generated implementation in your tests just use the following line

```java
CodeGenMock.mockCreate(TestImpl.class);
```

if for some reason you need a different mocking object than the generated one

```java
CodeFactory.registerType(Test.class, () -> mock(Test.class), () -> mock(Test.Modify.class));
```

### Mocking querying

To mock queries made by QueryEnricher you can do that by simply pass the query and wanted mocking object returned. 

```java
CodeGenMock.mockQuery(Test.find().by().id(5L), mockObj);
```

The mocked query will respect not only the query itself but the passed parameters as well. 

*for more examples check [here](https://github.com/binis2/code-generation-test/blob/master/src/test/java/codegen/TestMockFunctions.java)*

### Maven Dependency
```xml
    <dependency>
        <groupId>dev.binis</groupId>
        <artifactId>code-generator-test</artifactId>
        <version>0.1.0</version>
    </dependency>
```

### Other modules of the suite

Core - [https://github.com/binis2/code-generation-core]   
Generation Module - [https://github.com/binis2/code-generation]   
Spring Extension - [https://github.com/binis2/code-generation-spring]   
Annotation processor - [https://github.com/binis2/code-generation-annotation]   
Validation and Sanitization extension - [https://github.com/binis2/code-generation-validation] 
