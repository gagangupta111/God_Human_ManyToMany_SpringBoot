package com.godhuman.dao;

import com.godhuman.entity.God;
import com.godhuman.entity.Human;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
@Qualifier("HibernateData")
public class God_Human_Impl implements God_Human_dao {

    private static SessionFactory factory = new Configuration().configure().buildSessionFactory();

    public static void main(String[] args) {

        try {

            factory = new Configuration().configure().buildSessionFactory();

        } catch (Throwable ex) {

            System.err.println("Failed to create sessionFactory object." + ex);

        }

        God_Human_Impl GH = new God_Human_Impl();

        God god1 = new God("GOD1");
        God god2 = new God("GOD2");

        Human human1 = new Human("Human1");
        Human human2 = new Human("Human2");

        Set<Human> humanSet = new HashSet<Human>();
        humanSet.add(human1);
        humanSet.add(human2);

        Set<God> godSet = new HashSet<God>();
        godSet.add(god1);
        godSet.add(god2);

        god1.setHumans(humanSet);
        god2.setHumans(humanSet);

        human1.setGods(godSet);
        human2.setGods(godSet);

        GH.addGod("GOD1");
        GH.addGod("GOD2");

        List<God> list = GH.getAllGods();

        for (God god : list)
        System.out.println(god);

    }

    @Override
    public List<God> getAllGods() {

        Session session = factory.openSession();
        Transaction tx = null;
        List<God> gods = null;

        try {

            tx = session.beginTransaction();
            gods = session.createQuery("from God").list();
            tx.commit();

        } catch (HibernateException e) {

            if (tx!=null) tx.rollback();
            e.printStackTrace();

        } finally {

            session.close();

        }

        return gods;
    }

    @Override
    public List<Human> getAllHumans() {

        Session session = factory.openSession();
        Transaction tx = null;
        List<Human> humans = null;

        try {

            tx = session.beginTransaction();
            humans = session.createQuery("from Human").list();
            tx.commit();

        } catch (HibernateException e) {

            if (tx!=null) tx.rollback();
            e.printStackTrace();

        } finally {

            session.close();

        }

        return humans;

    }

    @Override
    public God getGodByID(Integer id) {

        Session session = factory.openSession();
        Transaction tx = null;
        God god = null;

        try {

            tx = session.beginTransaction();
             god =  (God) session.get(God.class, id);
            tx.commit();

        } catch (HibernateException e) {

            if (tx!=null) tx.rollback();
            e.printStackTrace();

        } finally {

            session.close();

        }

        return god;
    }

    @Override
    public Human getHumanByID(Integer id) {

        Session session = factory.openSession();
        Transaction tx = null;
        Human human = null;

        try {

            tx = session.beginTransaction();
            human =  (Human) session.get(God.class, id);
            tx.commit();

        } catch (HibernateException e) {

            if (tx!=null) tx.rollback();
            e.printStackTrace();

        } finally {

            session.close();

        }

        return human;
    }

    @Override
    public God addGod(String godName) {

        Session session = factory.openSession();
        Transaction tx = null;
        God god1 = null;
        Integer godID;

        try {

            tx = session.beginTransaction();
            god1 = new God(godName);
            godID = (Integer) session.save(god1);
            god1.setGodID(godID);
            tx.commit();

        } catch (HibernateException e) {

            if (tx!=null) tx.rollback();
            e.printStackTrace();

        } finally {

            session.close();

        }

        return god1;
    }

    @Override
    public Human addHuman(String humanName) {

        Session session = factory.openSession();
        Transaction tx = null;
        Human human = null;
        Integer humanID;

        try {

            tx = session.beginTransaction();
            human = new Human(humanName);
            humanID = (Integer) session.save(human);
            human.setHumanID(humanID);
            tx.commit();

        } catch (HibernateException e) {

            if (tx!=null) tx.rollback();
            e.printStackTrace();

        } finally {

            session.close();

        }

        return human;
    }

    @Override
    public God updateGod(God god) {

        Session session = factory.openSession();
        Transaction tx = null;
        God fetchedGOD = null;

        try {

            tx = session.beginTransaction();
            session.update(god);
            tx.commit();

        } catch (HibernateException e) {

            if (tx!=null) tx.rollback();
            e.printStackTrace();

        } finally {

            session.close();

        }

        return god;

    }

    @Override
    public Human updateHuman(Human human) {

        Session session = factory.openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            session.update(human);
            tx.commit();

        } catch (HibernateException e) {

            if (tx!=null) tx.rollback();
            e.printStackTrace();

        } finally {

            session.close();

        }

        return human;

    }

    @Override
    public Boolean deleteGodByID(Integer id) {

        Session session = factory.openSession();
        Transaction tx = null;
        God god = null;

        try {

            tx = session.beginTransaction();
            god = (God) session.load(God.class, id);
            session.delete(god);
            tx.commit();

        } catch (HibernateException e) {

            if (tx!=null) tx.rollback();
            e.printStackTrace();

        } finally {

            session.close();

        }

        if (god == null){
            return false;
        }
        return true;
    }

    @Override
    public Boolean deleteHumanByID(Integer id) {

        Session session = factory.openSession();
        Transaction tx = null;
        Human human = null;

        try {

            tx = session.beginTransaction();
            human = (Human) session.load(Human.class, id);
            session.delete(human);
            tx.commit();

        } catch (HibernateException e) {

            if (tx!=null) tx.rollback();
            e.printStackTrace();

        } finally {

            session.close();

        }

        if (human == null){
            return false;
        }
        return true;
    }
}
