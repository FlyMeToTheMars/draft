package com.hugh;

import com.hugh.pojo.Message;
import org.kie.api.KieServices;
import org.kie.api.event.rule.DebugAgendaEventListener;
import org.kie.api.event.rule.DebugRuleRuntimeEventListener;
import org.kie.api.logger.KieRuntimeLogger;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.util.ArrayList;

/**
 * @Author Fly.Hugh
 * @Date 2020/9/7 4:30 下午
 * @Version 1.0
 **/
public class HelloWorldExample {

    public static void main(String[] args) throws Exception {
        /**
         * From the kie services, a container is created from the classpath
         */
        final KieServices ks = KieServices.get();
        final KieContainer kc = ks.getKieClasspathContainer();

        execute( ks, kc );
    }

    public static void execute( KieServices ks, KieContainer kc ) {
        /** From the container, a session is created based on
            its definition and configuration in the META-INF/kmodule.xml file  */
        final KieSession ksession = kc.newKieSession("HelloWorldKS");

        /** Once the session is created, the application can interact with it
            In this case it is setting a global as defined in the
            org/drools/examples/helloworld/HelloWorld.drl file */
        ksession.setGlobal( "list", new ArrayList<Object>() );

        /** The application can also setup listeners */
        ksession.addEventListener( new DebugAgendaEventListener() );
        ksession.addEventListener( new DebugRuleRuntimeEventListener() );

        /** Set up a file based audit logger */
        KieRuntimeLogger logger = ks.getLoggers().newFileLogger( ksession, "./helloworld" );

        // To set up a ThreadedFileLogger, so that the audit view reflects events whilst debugging,
        // uncomment the next line
        // KieRuntimeLogger logger = ks.getLoggers().newThreadedFileLogger( ksession, "./helloworld", 1000 );

        // The application can insert facts into the session
        final Message message = new Message();
        message.setMessage( "Hello World" );
        message.setStatus( Message.HELLO );
        ksession.insert( message );

        // and fire the rules
        ksession.fireAllRules();

        // Close logger
        logger.close();

        // and then dispose the session
        ksession.dispose();
    }


}
