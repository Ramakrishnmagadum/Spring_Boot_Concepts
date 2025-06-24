package com.sample.CustomProfile;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.springframework.context.annotation.Profile;


//This will create Custom Annotation for "teacher" Profile 
//and Annotation name will be "@TeacherCustomProfile"
//after adding this annotation to Any class --> it will register Profile with name "teacher"..........
@Retention(RetentionPolicy.RUNTIME)
@Profile("teacher")
public @interface TeacherCustomProfile {

}
