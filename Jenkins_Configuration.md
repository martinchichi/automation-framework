Job Configuration - POM, Goals & Options
----------------------------------------
01- Click on created project > Configuration > Build Environment tab
On 'Root POM' box, paste the path to the 'pom.xml' (e.g.)C:\Users\{user}\automation-framework\pom.xml
On 'Gols and options' enter comands 'clean compile -Dcucumber.filter.tags="@regression' > [Save]
This will run the test related to the propper tag

In order to test it, you can click on 'Build Now', at this moment, this action will clean the code and compile it
A link (with the build number) to the related build action is shown on the 'Build History' section. Click > Console output textng.xml
----------
https://testng.org/doc/documentation-main.html#testng-xml
used to target the main runner class

Under the project
automation-framework>test>java>runners>[create a new package named testng]>[create new file named testng.xml]

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd" >

<suite name="Suite" parallel="classes" data-provider-thread-count="5"> --> this is the number opf tests to be ran
    <test name="Test">
        <classes>
            <class name="runners.MainRunner"></class>
        </classes>
    </test>
</suite>

Surefire-Plugin
---------------
This plugin target the testng.xml, in order to exdcute the number of test set on the 'data-provider-thread-count'
On POM

<plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-surefire-plugin</artifactId>
        <version>3.0.0-M5</version>
        <configuration>
             <suiteXmlFiles>
                 <suiteXmlFile>src/test/java/runners/testng/testng.xml</suiteXmlFile>
            </suiteXmlFiles>
        </configuration>
</plugin>

Enhanced Logs
-------------
01- Manage Jenkins > Manage Plugins
Available tab > type 'ansiColor' on the search box
Check 'Maven ansiColor' > [Install]
Go back to top page

02- Jenkins > Configure > 'Build Triggers' tab > Build Environment section
Check Color ANSI Color Output

Cucumber Reports
----------------
01- Manage Jenkins > Manage Plugins
Available tab > type 'Cucumber reports' on the search box
Check 'Cucumber reports' > [Install]
Go back to top page

02- Jenkins > Configure > 'Pre Steps' tab > Post-build section
On dropdown 'Add post-build action' > Cucumber reports >[Advanced...]

03- On JSON Report Location > JSON Reports Path
C:\Users\{user}\automation-framework\target > [Apply]
In order to test it, you can click on 'Build Now'
A link (with the build number) to the related build action is shown on the 'Build History' section. Click > Console output
Click on the build and a new option is shown 'Cucumber reports'

Targeting & Triggering Individual Test Suites
---------------------------------------------
01- Jenkins > Configure > 'General' tab > Description section
Check 'This project is parametrised'
On dropdown 'Add parameter' > Choice parameter >
Name (tag)>
Choices (regression login contact-us smoke)
On 'Gols and options' enter comands:
clean compile -Dcucumber.filter.tags="@${tag} > [Save]

02- On project home page click con 'Build with parameters'
tag dropdown is show, select any of the tags displayed > click [Build]

Parallelization
---------------
01-Jenkins > Configure > 'General' tab > Description section
Check 'This project is parametrised'
On dropdown 'Add parameter' > Choice parameter > Name (threadCount)>  Choices (1 2 3 4 5)
On 'Gols and options' enter comands:
clean compile -Dcucumber.filter.tags="@${tag}' -Ddataproviderthreadcount=${threadCount}> [Save]

02- On project home page click con 'Build with parameters'
threadCount dropdown is show, select any of the threadCount displayed > click [Build]

Ignore Test Suites & Individual Tests
-------------------------------------
01-Jenkins > Configure > 'General' tab > Build section
On 'Gols and options' enter comands:
clean compile -Dcucumber.filter.tags="(@${tag} and (not @ignored)) -Ddataproviderthreadcount=${threadCount}> [Save]

02- On cucumber.feature file, add the tag @ignored in order for that scenario to be ignored

Browser Selection
-----------------
01-Jenkins > Configure > 'General' tab > Description section
Check 'This project is parametrised'
On dropdown 'Add parameter' > Choice parameter > Name (browserType)>  Choices (chrome firefox)
On 'Gols and options' enter comands:
clean compile -Dcucumber.filter.tags="@${tag} -Ddataproviderthreadcount=${threadCount} -DbrowserType=${browserType}> [Save]

02- On framework > C:\Users\{user}\automation-framework\src\main\java\driverDriverFactory.java

/*
    private static String getBrowserType() {
        String browserType = null;
        //get the browser type from Jenkins
        String browserTypeRemoteValue = System.getProperty("browserType");
        try {
            if (browserTypeRemoteValue == null || browserTypeRemoteValue.isEmpty()) {
                Properties properties = new Properties();
                FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/properties/config.properties");
                properties.load(file);
                browserType = properties.getProperty("browser").toLowerCase().trim();
            } else {
                browserType = browserTypeRemoteValue;
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return browserType;
    }
*/

   

























 




















