package engine.pp.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.context.annotation.Bean;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class PersonDao {

    String url_name, path;

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

    @Bean
    public void getName(){

        String csvFile = "./data/health-list.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        ArrayList<String> music = new ArrayList<String>();
        ArrayList<String> gallery = new ArrayList<String>();

        try {
            br=new BufferedReader(new FileReader(csvFile));
            while ((line=br.readLine()) != null) {
                // use comma as separator
                String[] soundtracks=line.split(cvsSplitBy);
                System.out.println("[music= " + soundtracks[0] + "]");
                music.add(relaxingSound(soundtracks,0));
                Iterator itr1 = music.iterator();
                while(itr1.hasNext()) {
                    Object musiclist = itr1.next();
                    int musiclists = (int)musiclist;
                    url_name=musiclist.toString();
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

        saveSound(url_name);

    }

    public String relaxingSound(String soundtracks[],int p){
        String soundtracklist=null;
        for(int i=0;i<=soundtracks[p].length()-1;i++) {
            String sountracks2[] = soundtracks[i].split(",");
            soundtracklist = sountracks2[i] + soundtracks[i+1];
        }
        return soundtracklist;
    }

    public String getPath() {
        return path;
    }

}
