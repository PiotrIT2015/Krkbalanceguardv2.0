package engine.pp.controller;

import engine.pp.model.Person;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
class personControllerTest {

    @RequestMapping(value = "/shopping", method = RequestMethod.GET)
    public Person shopping() {

        Person emp = new Person();
        emp.setId(1);
        emp.getName();
        //emp.setDob("29/09/1988");

        return emp;
    }

}