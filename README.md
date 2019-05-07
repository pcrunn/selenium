# Selenium
Easy to use UI / GUI Framework for Bukkit

I mostly made this because [@crunesmh](https://github.com/crunesmh) deleted his oblique menu api.
I also made a video coding it for some reason and might upload it on youtube sometime.

[Click here for usage](https://github.com/pcrunn/selenium/blob/master/src/main/java/me/pcrunn/selenium/example/SeleniumExample.java)

## How do i use it?
Selenium uses the maven build tool, you can also use it without it though. I provided a guide for using it both with maven or without below.

### Maven:
- Simple, go to your pom.xml and add the following.
```xml
<repositories>
  <repository>
      <id>jitpack.io</id>
      <url>https://jitpack.io</url>
  </repository>
</repositories>
  
  <dependencies>
    <dependency>
        <groupId>com.github.pcrunn</groupId>
        <artifactId>selenium</artifactId>
        <version>1.0-SNAPSHOT</version>
    </dependency> 
  </depdendencies>
  ```
  
  or add them to your existing <repositories> and <dependencies> xml element.

### Without Maven: (not recommended, maven is epic)
- Download or clone the repository
- Take the source code and put it into your project
