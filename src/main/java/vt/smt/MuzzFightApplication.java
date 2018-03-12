package vt.smt;

import org.ocpsoft.rewrite.servlet.RewriteFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.faces.webapp.FacesServlet;
import javax.servlet.DispatcherType;
import java.util.EnumSet;

@SpringBootApplication
//@Configuration
//@SpringBootApplication
//@ComponentScan("vt.smt")
//@EnableJpaRepositories(basePackages="vt.smt.db.repositories")
//@EnableTransactionManagement
//@EntityScan(basePackages="vt.smt.ent")
public class MuzzFightApplication {
	public static void main(String[] args) {
		SpringApplication.run(MuzzFightApplication.class, args);
		System.out.println("We're starting!");
	}
	/*
	 *	configuring jsf
	 */
	@Bean
	public ServletRegistrationBean servletRegistrationBean() {
		FacesServlet servlet = new FacesServlet();
		return new ServletRegistrationBean(servlet, "*.jsf");
	}

	@Bean
	public FilterRegistrationBean rewriteFilter() {
		FilterRegistrationBean rwFilter = new FilterRegistrationBean(new RewriteFilter());
		rwFilter.setDispatcherTypes(EnumSet.of(DispatcherType.FORWARD, DispatcherType.REQUEST,
				DispatcherType.ASYNC, DispatcherType.ERROR));
		rwFilter.addUrlPatterns("/*");
		return rwFilter;
	}
}
