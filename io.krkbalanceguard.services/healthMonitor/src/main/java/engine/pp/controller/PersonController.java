package engine.pp.controller;

import engine.pp.dao.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/spring-boot-orm")
public class PersonController {

    @Autowired
    private PersonDao dao;

    @RequestMapping("/saveSound")
    public String save(@RequestBody String tracklist){
        dao.saveSound(tracklist);
        return "success";
    }
/*
    @GetMapping("/getAll")
    public List<Vote> getAllVote(){
        return dao.getVote();
    }
*/

}
