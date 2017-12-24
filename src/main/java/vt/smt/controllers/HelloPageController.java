package vt.smt.controllers;

import org.ocpsoft.rewrite.annotation.Join;
import org.springframework.context.annotation.Scope;

@Scope(value = "session")
@Join(path = "/", to = "/index.jsf")
public class HelloPageController {
}
