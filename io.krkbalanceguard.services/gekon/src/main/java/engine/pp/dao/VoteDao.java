package engine.pp.dao;

import engine.pp.services.windowService;
import org.springframework.context.annotation.Bean;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class VoteDao {

    windowService window=new windowService();
    private static final String FILE_SEPARATOR = "/";
    String item, path;

    public VoteDao() {

    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Autowired
    private SessionFactory factory;

    public void saveVote(String vote){
        getSession().save(vote);
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

    @Bean
    public void getItem(){
        String csvFile = "./data/resolution-list.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        ArrayList<String> resolutions = new ArrayList<String>();
        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] law = line.split(cvsSplitBy);
                System.out.println(" [law= " + law[0] + "]");
                for(int i=0;i<=law.length-1;i++)
                {
                    String resolution[] = law[2].split(cvsSplitBy);
                    String resolutionslist = resolution[i] + resolution[i+1];
                    resolutions.add(resolutionslist);
                }
                Iterator itr1 = resolutions.iterator();
                while(itr1.hasNext()) {
                    Object resolutionslist = itr1.next();
                    int resolutionslists = (int)resolutionslist;
                    item=resolutionslist.toString();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        saveVote(item);

    }


}
