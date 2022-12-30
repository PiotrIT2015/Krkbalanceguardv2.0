package engine.pp.gekon.dao;

import java.util.List;

import engine.pp.gekon.model.Vote;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class VoteDao {

    @Autowired
    private SessionFactory factory;

    public void saveVote(Vote vote){
        getSession().save(vote);
    }

    @SuppressWarnings("unchecked")
    public List<Vote> getVote(){
        return getSession().createCriteria(Vote.class).list();
    }

    private Session getSession(){
        Session session=factory.getCurrentSession();
        if(session==null){
            session=factory.openSession();
        }
        return session;
    }
}
