# yf-project

#### \*\*\* IMPORTANT LEGAL DISCLAIMER \*\*\*

---

**Yahoo!, Y!Finance, and Yahoo! finance are registered trademarks of
Yahoo, Inc.**

yf-project is **not** affiliated, endorsed, or vetted by Yahoo, Inc. It's
an open-source tool that uses Yahoo's publicly available data, and is
intended for research and educational purposes.

**You should refer to Yahoo!'s terms of use**
([here](https://legal.yahoo.com/us/en/yahoo/terms/otos/index.html) and
[here](https://policies.yahoo.com/us/en/yahoo/terms/index.htm)) **for
details on your rights to use the actual data downloaded.**

**yf-project** offers a way to download market data from [Yahoo!Ⓡ finance](https://finance.yahoo.com) in your Java project.
It offers synchronous and asynchronous methods. For the moment it does not offer historical data. It offers access to current values (key statistics and trading information, cash flows, balance sheets, income statements) as well as TTM values in some cases.

To use in your project add the dependency in your project:
```xml
<dependency>
    <groupId>org.opensource</groupId>
    <artifactId>yf-project</artifactId>
    <version>0.0.1</version>
</dependency>
```
 You may need to add the following dependencies in the dependency management section of your pom.xml:
```xml
<dependencyManagement>
    <dependencies>
        <!-- Managing Selenium versions -->
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-api</artifactId>
            <version>2.52.0</version>
        </dependency>
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-htmlunit-driver</artifactId>
            <version>2.52.0</version>
        </dependency>
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-support</artifactId>
            <version>2.52.0</version>
        </dependency>
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-remote-driver</artifactId>
            <version>2.52.0</version>
        </dependency>
        <!-- Managing HtmlUnit versions -->
        <dependency>
            <groupId>net.sourceforge.htmlunit</groupId>
            <artifactId>htmlunit</artifactId>
            <version>2.18</version>
        </dependency>
    </dependencies>
</dependencyManagement>
```
