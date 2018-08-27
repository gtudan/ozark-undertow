package de.tudan.example.undertow;

import io.undertow.Undertow;
import io.undertow.servlet.Servlets;
import io.undertow.servlet.api.DeploymentInfo;
import org.jboss.resteasy.plugins.server.undertow.UndertowJaxrsServer;
import org.jboss.resteasy.spi.ResteasyDeployment;


/**
 * @author Gregor Tudan, Cofinpro AG
 */
public class UndertowMain {
    public static void main(final String[] args) {
        UndertowJaxrsServer jaxrsServer = new UndertowJaxrsServer();
        Undertow.Builder localhost = Undertow.builder().addHttpListener(8080, "localhost");
        jaxrsServer.start(localhost);

        ResteasyDeployment deployment = new ResteasyDeployment();
        deployment.setInjectorFactoryClass("org.jboss.resteasy.cdi.CdiInjectorFactory");
        deployment.setApplicationClass(Application.class.getName());

        DeploymentInfo deploymentInfo = jaxrsServer.undertowDeployment(deployment);
        deploymentInfo
                .setClassLoader(UndertowMain.class.getClassLoader())
                .setContextPath("/mvc")
                .setDeploymentName("MVC")
                .addListener(Servlets.listener(org.jboss.weld.environment.servlet.Listener.class));

        jaxrsServer.deploy(deploymentInfo);

    }
}
