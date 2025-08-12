package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.Entity.Song;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       
    	Configuration cfg=new Configuration();
    	cfg.configure("hibernate.cfg.xml");
    	SessionFactory sf = cfg.buildSessionFactory();
    	Session session= sf.openSession();
    	Song song=new Song();
    	song.setId(1);
    	song.setName("Jai Shree ram");
    	song.setArtist("Someone");
    	session.save(song);
    	
    	
    }
}
