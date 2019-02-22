package com.asu.ser516.team47.main;

import java.io.File;

import com.asu.ser516.team47.servlet.SubmissionServlet;

import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;

public class Main {

    public static void main(String[] args) throws Exception {
        String context_Path = "";
        String base_path = new File("WebContent").getAbsolutePath();

        Tomcat tomcat = new Tomcat();
        tomcat.setBaseDir(base_path);
        tomcat.setPort(8080);
        tomcat.getHost().setAppBase(base_path);

        Context context = tomcat.addWebapp(context_Path, base_path);

        String servletName = "SubmissionServlet";

        tomcat.addServlet(context_Path, servletName, new SubmissionServlet());
        context.addServletMappingDecoded("/submit", servletName);

        tomcat.start();
        tomcat.getServer().await();
    }
}