package pt.ipb.jsf.demo;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ManagedBean
public class HelloWorld {
  private static final Logger logger = LoggerFactory.getLogger(HelloWorld.class);
  private String firstName = "John";
  private String lastName = "Doe";

  public HelloWorld() {
    logger.debug("HelloWorld.HelloWorld");
  }

  @PostConstruct
  public void init() {
    ExternalContext ctx = FacesContext.getCurrentInstance().getExternalContext();
    HttpServletRequest request = (HttpServletRequest) ctx.getRequest();
    logger.debug("request: {}", request);
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String showGreeting() {
    return "Hello" + " " + firstName + " " + lastName + "!";
  }
}
