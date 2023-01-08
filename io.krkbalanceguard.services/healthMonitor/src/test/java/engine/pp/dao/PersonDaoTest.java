package engine.pp.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonDaoTest {

    private PersonDao persondao;

    @BeforeEach
    void setUp() {
        persondao=new PersonDao();
    }

    @Test
    void getPath() {
        persondao.setPath("./data/resolution-list.csv");
        assertEquals("./data/resolution-list.csv",persondao.getPath());
    }

}