package engine.pp.controller;

import engine.pp.model.Vote;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class voterControllerTest {

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public Vote vote() {

        Vote emp = new Vote();
        emp.setId(1);
        emp.setItem("yes");
        //emp.setDob("29/09/1988");

        return emp;
    }

}