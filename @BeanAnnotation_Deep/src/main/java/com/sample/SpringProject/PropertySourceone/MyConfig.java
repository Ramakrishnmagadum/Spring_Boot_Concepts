package com.sample.SpringProject.PropertySourceone;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan
public class MyConfig {

	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	
//	----------------------------------
	@Bean
//	or we can mention here itself as @Qulifier   --But If ANy object having @primary the first priorty will be given to @primary Annotated Object...
	public Film film(@Qualifier("srk") Actor actor) {
		return new Film(actor);
	}
	
    @Primary  // --we can give as primary to it will consider this as First Object 
	@Bean
	public SRK srk() {
		return new SRK();
	}
	
	@Bean
	public SSR ssr() {
		return new SSR();
	}
	
	@Bean
	public YASH yash() {
		return new YASH();
	}
}
