package de.tudan.example.undertow;

import org.mvcspec.ozark.bootstrap.OzarkCoreFeature;

import javax.mvc.engine.ViewEngine;
import javax.ws.rs.ApplicationPath;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Gregor Tudan, Cofinpro AG
 */
@ApplicationPath("/")
public class Application extends javax.ws.rs.core.Application {
    @Override
    public Map<String, Object> getProperties() {
        Map<String, Object> properties = new HashMap<>();
        properties.put(ViewEngine.VIEW_FOLDER, "/views/");
        return properties;
    }

    @Override
    public Set<Class<?>> getClasses() {
        HashSet<Class<?>> classes = new HashSet<>();
        classes.add(HelloController.class);
        classes.add(OzarkCoreFeature.class);
        return classes;
    }
}
