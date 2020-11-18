/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Framework2ConsumeAPI.controllers;

import com.example.Framework2ConsumeAPI.entities.Person;
import com.example.Framework2ConsumeAPI.services.PersonRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author acer
 */
@RequestMapping("person")
public class PersonRestController {
   
     @Autowired
    PersonRestService service;
    
    @GetMapping("")
    public String index(Model model){
        model.addAttribute("people", service.getAll());
        model.addAttribute("person", new Person());
        model.addAttribute("person", new Person());
        return "index";
    }
    
    @GetMapping("/{id}")
    public String getId(Model model,  @PathVariable("id") String id) {
        model.addAttribute("person", service.getById(id));
        model.addAttribute("people", service.getAll());
        return "index";
    }
    
    @PostMapping("save")
    public String save(Person person){
        service.save(person);
        return "redirect:/";
    }
    @RequestMapping(value = "delete/{id}", method = { RequestMethod.GET, RequestMethod.POST })
    public String delete(@PathVariable("id") String id) {
        service.delete(id);
        return "redirect:/";
    }
    
    @GetMapping("/gender/male")
    public String getMaleGender(Model model) {
        model.addAttribute("person", new Person());
        model.addAttribute("people", service.getMaleGender("male"));
        return "index";
    }
    
    @GetMapping("/gender/female")
    public String getFemaleGender(Model model) {
        model.addAttribute("person", new Person());
        model.addAttribute("people", service.getFemaleGender("female"));
        return "index";
    }

}
