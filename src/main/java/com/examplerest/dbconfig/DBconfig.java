package com.examplerest.dbconfig;

import com.examplerest.utilities.EncryptionUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Data
@Component
public class DBconfig {
    

   private DatabaseProperties db;

    private EncryptionProperties encruptionProperties;

    @Autowired
    public DBconfig(DatabaseProperties db, EncryptionProperties encruptionProperties){
        this.db=db;
        this.encruptionProperties = encruptionProperties;
    }

    @Bean
    public DataSource postgreSQLsource() throws Exception {
    	
    	String decryptedPwd = EncryptionUtil.encrypt(db.getPasswordEncrypted(), encruptionProperties.getKey());
        String pwd = EncryptionUtil.decrypt(decryptedPwd,encruptionProperties.getKey());
    	db.setPasswordEncrypted(pwd);
     
    	DataSourceBuilder dataSource =DataSourceBuilder.create();
        dataSource.username(db.getUsername());
        dataSource.password(db.getPasswordEncrypted());
        dataSource.url(db.getUrl());
        dataSource.driverClassName(db.getDriverClass());
        return dataSource.build();
    }
}
