/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Framework2ConsumeAPI.entities.rest;

import lombok.Data;

/**
 *
 * @author Acer
 */
@Data
public class LoginOutput {
 
    private UserOutput user;
    private String status;
    
    
}
