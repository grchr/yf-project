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
It offers synchronous and asynchronous methods. It is split in 2 modules: yf-project-app and yf-project-api.
The yf-project-app is based on retrieving data from the yahoo finance web page via targeted field reading. It offers access to current values (key statistics and trading information, cash flows, balance sheets, income statements) as well as TTM values in some cases. It will probably not be maintained in the future.
The yf-project-api is based on retrieving data from the yahoo finance api endpoints. It contains more raw data, including historical data.

To use the yf-project-app in your project add the dependency using the bom set up:
```xml
<dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>com.github.grchr</groupId>
                <artifactId>yf-project-bom</artifactId>
                <version>0.0.15</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>
```
Then add the dependency to the library:
```xml
<dependencies>
        <dependency>
            <groupId>com.github.grchr</groupId>
            <artifactId>yf-project-app</artifactId>
        </dependency>
</dependencies>
```
To use the yf-project-api in your project add the dependency using the bom set up:
```xml
<dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>com.github.grchr</groupId>
                <artifactId>yf-project-bom</artifactId>
                <version>0.0.15</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>
```
Then add the dependency to the library:
```xml
<dependencies>
        <dependency>
            <groupId>com.github.grchr</groupId>
            <artifactId>yf-project-api</artifactId>
        </dependency>
</dependencies>
```
