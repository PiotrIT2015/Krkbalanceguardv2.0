package engine.pp.gekon.controller;

import java.util.List;

import engine.pp.gekon.dao.VoteDao;
import engine.pp.gekon.model.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/spring-boot-orm")
public class voterController {

    @Autowired
    private VoteDao dao;

    @RequestMapping("/saveVote")
    public String save(@RequestBody String vote){
        dao.saveVote(vote);
        return "success";
    }
/*
    @GetMapping("/getAll")
    public List<Vote> getAllVote(){
        return dao.getVote();
    }
*/
}
