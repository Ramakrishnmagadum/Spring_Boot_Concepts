package com.sample.SpringProject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

@Component
//This will load Resources while creating object for this.....
public class ResourceLoaderExample implements ResourceLoaderAware {

	public ResourceLoaderExample() {
		super();
		System.out.println("ResourceLoader constructer is Initialized...");
	}

	public void setResourceLoader(ResourceLoader resourceLoader) {
		System.out.println("#ResourceLoaderAware");
		Resource resource = resourceLoader.getResource("classpath:SimpleBanner.txt");
		try {
			InputStream inputStream = resource.getInputStream();
			BufferedReader bf = new BufferedReader(new InputStreamReader(inputStream));
			String line = bf.readLine();
			while (line != null) {
				System.out.println(line);
				line = bf.readLine();
			}
			System.out.println("\n  \n");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
