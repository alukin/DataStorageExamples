/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.cn.al.teach.daexmpl.service;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author al
 */
public class DBConfig {
    public static final String PU_NAME_PG="ua.cn.al.teach_JPAexample_PG";
    public static final String PU_NAME_MARIA="ua.cn.al.teach_JPAexample_MARIA";
    public static String puName=PU_NAME_PG;
    public static void setup(String pu_name){
        
    }
    public static EntityManagerFactory createEmFactory(){
        return Persistence.createEntityManagerFactory(puName);
    }
}
