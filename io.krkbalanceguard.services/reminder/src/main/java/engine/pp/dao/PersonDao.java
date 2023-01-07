package engine.pp.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class PersonDao {

    String items;
    @Autowired
    private SessionFactory factory;

    public void saveShopping(String shoppinglist){
        getSession().save(shoppinglist);
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
        String csvFile = "./data/shopping-list.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        ArrayList<String> shoppings = new ArrayList<String>();
        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] shopping = line.split(cvsSplitBy);
                System.out.println(" [law= " + shopping[0] + "]");
                for(int i=0;i<=shopping.length-1;i++)
                {
                    String resolution[] = shopping[2].split(cvsSplitBy);
                    String resolutionslist = resolution[i] + resolution[i+1];
                    shoppings.add(resolutionslist);
                }
                Iterator itr1 = shoppings.iterator();
                while(itr1.hasNext()) {
                    Object resolutionslist = itr1.next();
                    int resolutionslists = (int)resolutionslist;
                    items=resolutionslist.toString();
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

        saveShopping(items);

    }

}
