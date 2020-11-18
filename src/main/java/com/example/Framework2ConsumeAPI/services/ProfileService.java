/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Framework2ConsumeAPI.services;

import com.example.Framework2ConsumeAPI.entities.rest.ProfileAddress;
import com.example.Framework2ConsumeAPI.entities.rest.ProfileContact;
import com.example.Framework2ConsumeAPI.entities.rest.ProfileEducation;
import com.example.Framework2ConsumeAPI.entities.rest.ProfileInfo;
import com.example.Framework2ConsumeAPI.entities.rest.ProfileOccupation;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Acer
 */
@Service
public class ProfileService {
    
    @Autowired
    RestTemplate restTemplate;

    @Value("${api.uri}")
    private String uri;
    
    
    public ProfileInfo getProfileInfo(String id){
        ProfileInfo result;
        Map<String, String> param = new HashMap<>();
        
        param.put("id", id);
        
        result = restTemplate.getForObject(uri + "profile/basic/{id}", ProfileInfo.class, param);
        return result;
    }
    
    
    public ProfileAddress getProfileAddress(String id){
        ProfileAddress result;
        Map<String, String> param = new HashMap<>();
        
        param.put("id", id);
        
        result = restTemplate.getForObject(uri + "profile/address/{id}", ProfileAddress.class, param);
        return result;
    }
    
    
    public ProfileContact getProfileContact(String id){
        ProfileContact result;
        Map<String, String> param = new HashMap<>();
        
        param.put("id", id);
        
        result = restTemplate.getForObject(uri + "profile/contact/{id}", ProfileContact.class, param);
        return result;
    }
    
    public ProfileOccupation getProfileOccupation(String id){
        ProfileOccupation result;
        Map<String, String> param = new HashMap<>();
        
        param.put("id", id);
        
        result = restTemplate.getForObject(uri + "profile/currentoccupation/{id}", ProfileOccupation.class, param);
        return result;
    }
    
    public ProfileEducation getProfileEducation(String id){
        ProfileEducation result;
        Map<String, String> param = new HashMap<>();
        
        param.put("id", id);
        
        result = restTemplate.getForObject(uri + "profile/education/{id}", ProfileEducation.class, param);
        return result;
    }
    
    //Update Data
    
    public boolean updateProfileBasic(ProfileInfo input) {
        HttpEntity<ProfileInfo> request = new HttpEntity<>(input, null);
        ResponseEntity<Boolean> responseEntity = restTemplate.exchange("http://116.254.101.228:8080/ma_test/profile/basic",
                HttpMethod.POST,
                request,
                new ParameterizedTypeReference<Boolean>() {
        }
        );
        return responseEntity.getBody();
    }
    
}
