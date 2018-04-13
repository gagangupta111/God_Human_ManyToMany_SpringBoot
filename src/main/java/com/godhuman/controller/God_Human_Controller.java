package com.godhuman.controller;

import com.godhuman.entity.God;
import com.godhuman.entity.Human;
import com.godhuman.service.God_Human_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/Gods")
public class God_Human_Controller {

    @Autowired
    private God_Human_Service god_human_service;


    @RequestMapping(method = RequestMethod.GET)
    public Collection<God> getAllGods(){
        List<God> list = god_human_service.getAllGods();
        return list;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public God getGodById(@PathVariable("id") int id){
        return god_human_service.getGodByID(id);
    }

    @RequestMapping(value = "/create/{godName}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public God createSale(@PathVariable("godName") String godName){
        return god_human_service.addGod(godName);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public God updateSale(@RequestBody God god){
        return god_human_service.updateGod(god);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteSaleById(@PathVariable("id") int id){
        god_human_service.deleteGodByID(id);
    }



    @RequestMapping(value = "/humans",method = RequestMethod.GET)
    public Collection<Human> getAllHumans(){
        return god_human_service.getAllHumans();
    }

    @RequestMapping(value = "/humans/{id}", method = RequestMethod.GET)
    public Human getHumanByID(@PathVariable("id") int id){
        return god_human_service.getHumanByID(id);
    }

    @RequestMapping(value = "/humans/create/{humanName}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Human addHuman(@PathVariable("humanName") String humanName){
        return god_human_service.addHuman(humanName);
    }

    @RequestMapping(value = "/humans/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Human updateHuman(@RequestBody Human human){
        return god_human_service.updateHuman(human);
    }

    @RequestMapping(value = "/humans/{id}", method = RequestMethod.DELETE)
    public void deleteHumanByID(@PathVariable("id") int id){
        god_human_service.deleteHumanByID(id);
    }


}