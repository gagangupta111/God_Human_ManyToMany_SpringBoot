package com.godhuman.service;

import com.godhuman.dao.God_Human_dao;
import com.godhuman.entity.God;
import com.godhuman.entity.Human;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class God_Human_Service {

    @Autowired
    @Qualifier("HibernateData")
    private God_Human_dao godHumanDao;

    public List<God> getAllGods(){
        return godHumanDao.getAllGods();
    }
    public List<Human> getAllHumans(){
        return godHumanDao.getAllHumans();
    }

    public God getGodByID(Integer id){
        return godHumanDao.getGodByID(id);
    }

    public Human getHumanByID(Integer id){
        return godHumanDao.getHumanByID(id);
    }

    public God addGod(String godName){

        return godHumanDao.addGod(godName);

    }
    public Human addHuman(String humanName){
        return godHumanDao.addHuman(humanName);
    }

    public God updateGod(God god){
        return godHumanDao.updateGod(god);
    }

    public Human updateHuman(Human human){
        return godHumanDao.updateHuman(human);
    }

    public Boolean deleteGodByID(Integer id){
        return godHumanDao.deleteGodByID(id);
    }

    public Boolean deleteHumanByID(Integer id){
        return godHumanDao.deleteHumanByID(id);
    }

}
