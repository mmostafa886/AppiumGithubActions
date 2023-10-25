# AppiumGithubActions
## Trial branch for the GHActions 

1. The user can execute the test & generate Allure reports locally (not on Github Actions) executing the command (mvn clean test -P<pom.xml Profile_Name> allure:serve) [check the profile example below]
2. The Workflow file (allure-android-2machines.yml) was added to execute the tests on Macos machine then use Ubuntu machine to generate Allure report
3. In order to execute specific TestNG XML file, the user needs to create a profile in the POM.xml specifying the Target XML file in the section (suiteXmlFiles)[check the profile example below] then execute the command (mvn clean test -P<Profile_Name>)


    <profile>
            <id>android02</id>
            <build>
                <plugins>
                    <plugin>
                        <groupId>org.apache.maven.plugins</groupId>
                        <artifactId>maven-surefire-plugin</artifactId>
                        <version>3.1.2</version>
                        <configuration>
                            <testFailureIgnore>true</testFailureIgnore>
                            <argLine>
                                -javaagent:"${settings.localRepository}/org/aspectj/aspectjweaver/${aspectj.version}/aspectjweaver-${aspectj.version}.jar"
                            </argLine>
                            <suiteXmlFiles>
                                <suiteXmlFile>AndroidTestNG002.xml</suiteXmlFile>
                            </suiteXmlFiles>
                            <systemPropertyVariables>
                                <allure.results.directory>target/allure-results</allure.results.directory>
                            </systemPropertyVariables>
                        </configuration>
                        <dependencies>
                            <dependency>
                                <groupId>org.aspectj</groupId>
                                <artifactId>aspectjweaver</artifactId>
                                <version>${aspectj.version}</version>
                            </dependency>
                        </dependencies>
                    </plugin>
                    <plugin>
                        <groupId>io.qameta.allure</groupId>
                        <artifactId>allure-maven</artifactId>
                        <version>2.12.0</version>
                    </plugin>
                </plugins>
            </build>
        </profile>


4. To run a generic test cases (through the profile, config files,..... ), the user need to execute the command (mvn clean test -Pandroid -DconfigFilePath=configFiles/android.properties allure:serve) [of course after doing all the needed config provided within this branch].
5. To write a general command (mvn clean test -P<profile_from_xml> -DconfigFilePath=<path_to_properties_file> allure:serve)