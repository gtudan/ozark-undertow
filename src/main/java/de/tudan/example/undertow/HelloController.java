package de.tudan.example.undertow;

import javax.mvc.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * @author Gregor Tudan, Cofinpro AG
 */
@Controller
@Path("/hello")
public class HelloController {

    @GET
    public String hello() {
        return "hello.jsp";
    }
}

