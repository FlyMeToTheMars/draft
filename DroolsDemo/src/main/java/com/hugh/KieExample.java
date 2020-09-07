package com.hugh;

import com.hugh.pojo.Message;
import org.kie.api.KieServices;
import org.kie.api.event.rule.DebugAgendaEventListener;
import org.kie.api.event.rule.DebugRuleRuntimeEventListener;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.util.ArrayList;

/**
 * @Author Fly.Hugh
 * @Date 2020/9/7 1:48 下午
 * @Version 1.0
 **/
public class KieExample {
    public static void main(String[] args) {
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.getKieClasspathContainer();

    }

    public static void execute( KieContainer kc ) {
        KieSession ksession = kc.newKieSession("HelloWorldKS");

        ksession.setGlobal( "list",
                new ArrayList<Object>() );

        ksession.addEventListener( new DebugAgendaEventListener() );
        ksession.addEventListener( new DebugRuleRuntimeEventListener() );

        Message message = new Message();

        message.setMessage( "Hello World" );
        message.setStatus( Message.HELLO );
        ksession.insert( message );

        ksession.fireAllRules();
        ksession.dispose();
    }
}
