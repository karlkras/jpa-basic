# jpa-basic
This repo provides a baseline on how to work with WildFly to setup a datasource and mysql interface to use JPA for interacting with our databases.
## Setup with WildFly and Intellij

### WildFly
For purposes of this demo, I'm using WildFly v20 though 19 should work perfectly well too.
1) Download, install, and configure a local instance of the [wildfly server](https://www.wildfly.org/downloads/)  
You'll need to define a admin user.
2. Define the mysql connector to the server (this is using the latest version 8, 5 has been tested as well).  
   1. [Download the connector](https://dev.mysql.com/downloads/connector/j/)  
      Exract contained `mysql-connector-java-8xxx.jar` file.   
      Copy this to [wildfly-home]\modules\system\layers\base\com\mysql\main (you will probably have to create the `mysql\main` subdirectories).
   2. Create a module.xml file with the following content   
    ``` xml
    <module xmlns="urn:jboss:module:1.5" name="com.mysql">
     <resources>
      <resource-root path="mysql-connector-java-8xxx.jar" />
     </resources>
     <dependencies>
      <module name="javax.api"/>
      <module name="javax.transaction.api"/>
     </dependencies>
    </module>
    ```   
       and again, Copy this to [wildfly-home]\modules\system\layers\base\com\mysql\main
   3. Start wildfly with standalone.bat from command line -   
   `$> [wildfly-home]\bin\standalone.bat`   
   You should see no errors in the terminal output and should see a couple of lines similar to this:   
   ```
   12:42:27,004 INFO  [org.jboss.as.connector.subsystems.datasources] (ServerService Thread Pool -- 44) WFLYJCA0005: Deploying non-JDBC-compliant driver class com.mysql.cj.jdbc.Driver (version 8.0) 
   12:42:27,026 INFO  [org.jboss.as.connector.deployers.jdbc] (MSC service thread 1-2) WFLYJCA0018: Started Driver service with driver-name = mysql  
   ```
3. Define the datasource   
   1. Start the WildFly admin console:   
      http://localhost:9990   
   2. Navigate to the [Configuration->Subsystem->Datasources & Drivers->datasources](http://localhost:9990/console/index.html#configuration;path=configuration~subsystems!css~datasources!data-source-driver~datasources) selection.   
   3. Chose `Add Datasource` from the drop-down next to the `Datasources` header.   
   4. In resulting wizard you should have a MySql option, select this, then `Next`   
   5. In Next panel Give your datasource a recognizable name, in my case I was setting up a connection to the local `misc` database so I called it `MySqlMisc`  
   and provide a valid JNDI name, e.g., `java:/MySqlMisc` and select `Next`   
   6. Next panel should already have the correct information. Nothing to do here but hit `Next`   
   7. Provide the connection information. I was using `misc` so `jdbc:mysql://localhost:3306/misc` and user/pw credentials... `Next`   
   8. This panel will let you test the connection. Do it. If it fails you need to go back through this, otherwise `Next`   
   9. The Summary page... nirvana. `Finish`   
   
This should be all that's needed for WildFly configuration.
### Intellij
   
* do this  
* do that
