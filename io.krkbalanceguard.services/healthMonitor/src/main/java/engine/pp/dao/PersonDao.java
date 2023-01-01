package engine.pp.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class PersonDao {

    @Autowired
    private SessionFactory factory;

    public void saveSound(String tracklist){
        getSession().save(tracklist);
    }
    /*
        @SuppressWarnings("unchecked")
        public List<Vote> getVote(){
            return getSession().criteriaBuilder().createQuery(Vote.class).list();
        }
    */
    private Session getSession(){
        Session session=factory.getCurrentSession();
        if(session==null){
            session=factory.openSession();
        }
        return session;
    }

}
