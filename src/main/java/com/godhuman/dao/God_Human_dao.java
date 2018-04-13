package com.godhuman.dao;

import com.godhuman.entity.God;
import com.godhuman.entity.Human;
import java.util.List;

public interface God_Human_dao {

    public List<God> getAllGods();
    public List<Human> getAllHumans();

    public God getGodByID(Integer id);
    public Human getHumanByID(Integer id);

    public God addGod(String godName);
    public Human addHuman(String humanName);

    public God updateGod(God god);
    public Human updateHuman(Human human);

    public Boolean deleteGodByID(Integer id);
    public Boolean deleteHumanByID(Integer id);

}