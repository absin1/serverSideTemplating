package com;
import static java.nio.file.StandardWatchEventKinds.*;

import java.io.IOException;

import java.io.StringWriter;

import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

public class TestVelocity {
	private static WatcherService watcherService; 
	  
	public String getData() throws IOException {
		/*  first, get and initialize an engine  */
        VelocityEngine ve = getVelocityEngine();
        ve.init();
        /*  next, get the Template  */
        Template t = ve.getTemplate( "helloworld.vm" );
        /*  create a context and add data */
        VelocityContext context = new VelocityContext();
        context.put("name", "dhdhdh");
        /* now render the template into a StringWriter */
        StringWriter writer = new StringWriter();
        t.merge( context, writer );
        /* show the World */
        System.out.println( writer.toString() ); 
        return writer.toString() ;
	}
	
	
	public String getCaurosel() throws IOException {
		VelocityEngine ve = getVelocityEngine();
        ve.init();
        /*  next, get the Template  */
        Template t = ve.getTemplate( "caurosel.vm" );
        /*  create a context and add data */
        VelocityContext context = new VelocityContext();
        context.put("xxx", "Card Title");
        /* now render the template into a StringWriter */
        StringWriter writer = new StringWriter();
        t.merge( context, writer );
        /* show the World */
        System.out.println( writer.toString() ); 
        return writer.toString() ;
	}
	
	
	
	public  VelocityEngine  getVelocityEngine() throws IOException{

	    VelocityEngine ve = new VelocityEngine();
	    Properties props = new Properties();
	    // THIS PATH CAN BE HARDCODED BUT IDEALLY YOUD GET IT FROM A PROPERTIES FILE
	    props.put("file.resource.loader.path", TestVelocity.class.getResource("/templates").getFile());
	    props.setProperty("runtime.log.logsystem.class", "org.apache.velocity.runtime.log.NullLogSystem");
	    ve.init(props);
	    System.err.println(TestVelocity.class.getResource("/templates").getFile().replaceFirst("^/(.:/)", "$1"));
	    Path dir = Paths.get(TestVelocity.class.getResource("/templates").getFile().replaceFirst("^/(.:/)", "$1"));
	    Multi t1=new Multi(dir);
	    t1.start();
	  
	    return ve;
	}
	
	
	
	
	
	
	
	
}
