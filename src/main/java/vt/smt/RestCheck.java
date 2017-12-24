package vt.smt;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestCheck {
    private class Answer{
        String content;
    }

    @RequestMapping("/check")
    public Answer check(){
        Answer a = new Answer();
        a.content = "We're alive";
        return a;
    }
}