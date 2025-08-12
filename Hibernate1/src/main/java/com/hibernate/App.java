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
    	cfg.addAnnotatedClass(Song.class);//# This will take care of mapping this class to DB ...No need to mention in mapping.xml.....
    	SessionFactory sf = cfg.buildSessionFactory();
    	Session session= sf.openSession();
    	Song song=new Song();
    	song.setId(40);
    	song.setName("Jai Shree ram");
    	song.setArtist("Someone");
    	
//    	First start the Transaction ...
    	session.beginTransaction();
    	session.save(song);
    	song.setName("demo");
//    	For permanent save ...Commit the Transaction......
    	session.getTransaction().commit();
    	
    }
}
