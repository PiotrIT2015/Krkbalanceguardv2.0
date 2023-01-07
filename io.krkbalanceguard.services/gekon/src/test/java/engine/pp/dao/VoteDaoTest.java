package engine.pp.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VoteDaoTest {

    private VoteDao votedao;

    @BeforeEach
    void setUp() {
        votedao=new VoteDao();
    }

    @Test
    void getPath() {
        votedao.setPath("./data/resolution-list.csv");
        assertEquals("./data/resolution-list.csv",votedao.getPath());
    }

    /*
    @Test
    void getItem() {
        votedao.setItem("resolution1");
        assertEquals("resolution1",votedao.getItem());
    }
     */

}