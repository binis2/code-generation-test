# code-generation-test

Unit testing routines for Binis CodeGen Library.

For usage examples please see [https://github.com/binis2/code-generation]    
For full project examples please see [https://github.com/binis2/code-generation-examples] 

### Introduction

Module to help writing unit tests for code that uses Binis CodeGen library. This testing suite is based on JUnit5 and Mockito libraries.

### JUnit Extension

For easier unit test writing, there is a dedicated JUnit extension. It will handle do automatic handling for mocking the necessary internal routines for Binis CodeGen suite.  

```java
@ExtendWith(CodeGenExtension.class)
class MyCodeGenTest {
    ...
}
```

### Mocking creation

To make one's life easier the Binis CodeGen library has a way to tag default implementation for an interface. This reduces the need of creating dedicated mock objects for the generated entities. So code like this

```java
User.create().id(5L).done();
```

where **User** is interface will just work seamlessly if the default implementation is available in the scope of test. In case of missing default implementation this is how another one can be set.      

```java
CodeGenMock.mockCreate(UserImpl.class);
```

If for some reason a different mocking object is needed there is possibility to mock the factory itself. 

```java
CodeFactory.registerType(User.class, () -> mock(User.class), () -> mock(User.Modify.class));
```

### Mocking queries

To mock queries made by QueryEnricher you can do that by simply pass the query and wanted mocking object returned. 

```java
CodeGenMock.mockQuery(Test.find().by().id(5L), mockObj);
```

The mocked query will respect not only the query itself but the passed parameters as well. If there is need to mock a specific query with different parameters there are matchers present similar to Mokito ones.

```java
CodeGenMock.mockQuery(Test.find().by().id(CodeGenMatcher.any()), mockObj);
```
or
```java
CodeGenMock.mockJustQuery(Test.find().by().id(5L), mockObj);
```

Count and exists queries needs special mocking so queries like these

```java
Test.find().by().status(Status.ACTIVE).count();
Test.find().by().username("Binis").exists();
```
can be mocked this way 
```java
CodeGenMock.mockCountQuery(Test.find().by().status(Status.ACTIVE), mockObj);
CodeGenMock.mockExistsQuery(Test.find().by().username("Binis"), mockObj);
```

For easy paging mocking mocking like this can be used
```java
CodeGenMock.mockPageQuery(Test.find().by().status(Status.ACTIVE), List.of(mockObj));
```


By default, the mocking framework expects every query mock to called only ones in the scope of the text. If that is not the case a expected call count must be specified.

```java
mockQuery(Test.find().by().id(any()), mockObj).called(never());
mockQuery(Test.find().by().id(any()), mockObj).called(once());
mockQuery(Test.find().by().id(any()), mockObj).called(twice());
mockQuery(Test.find().by().id(any()), mockObj).called(thrice());
mockQuery(Test.find().by().id(any()), mockObj).called(times(4));
```

if call count should not be taken into consideration it can be turned off by   

```java
CodeGenMock.mockQuery(Test.find().by().id(CodeGenMatcher.any()), mockObj).fails(false);
```

*for more complex query examples check [here](https://github.com/binis2/code-generation-test/blob/master/src/test/java/codegen/QueryEnrichTest.java)*

### Mocking persistence routines

If an entity uses persistence modifier extension if there is a need to verify if a certain persistence routine is called it can be checked like this
```java
//Production
User.find().by().id(5L).with().status(Status.ACTIVE).save();
//Unit test
mockQuery(Test.find().by().id(CodeGenMatcher.any()), mockObj);
verifySave(mockObj).called(once());
```
or if there is need to modify a mock object during specific persistence operation to simulate so specific DB behavior, the way to do that is this  
```java
onSave(mockObj, () -> mockObj.id(5L));
```

*for reference library's own unit test can be found [here](https://github.com/binis2/code-generation-test/blob/master/src/test/java/codegen/TestMockFunctions.java)*


### Maven Dependency
```xml
    <dependency>
        <groupId>dev.binis</groupId>
        <artifactId>code-generator-test</artifactId>
        <version>1.2.0</version>
    </dependency>
```

### Other modules of the suite

Core - [https://github.com/binis2/code-generation-core]   
Generation Module - [https://github.com/binis2/code-generation]   
Spring Extension - [https://github.com/binis2/code-generation-spring]   
Annotation processor - [https://github.com/binis2/code-generation-annotation]   
Validation and Sanitization extension - [https://github.com/binis2/code-generation-validation]   
Jackson support - [https://github.com/binis2/code-generation-jackson]   
Spring Boot configuration - [https://github.com/binis2/code-generation-spring-configuration]   
Projections support - [https://github.com/binis2/code-generation-projection]   
Hibernate support - [https://github.com/binis2/code-generation-hibernate]   