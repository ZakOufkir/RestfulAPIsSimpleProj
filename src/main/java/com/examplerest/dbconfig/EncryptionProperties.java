package com.examplerest.dbconfig;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Configuration
@ConfigurationProperties(prefix = "encryption")
@Component
public class EncryptionProperties {
	
	

    @Value("${encryption.key}")
    private String key;
    public String getKey(){
        return key;
    };
    public void setKey(String key){
        this.key = key;
    }
}
