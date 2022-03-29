package dev.jhonnatan.springvaultpoc.datasource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.support.VaultResponseSupport;

import javax.sql.DataSource;

@Configuration
public class DatasourceEnvironmentConfiguration {

    private final VaultTemplate vaultTemplate;

    public DatasourceEnvironmentConfiguration(VaultTemplate vaultTemplate) {
        this.vaultTemplate = vaultTemplate;
    }

    @Bean
    public DataSource createDatasourceConfig() {

        VaultResponseSupport<DatasourceInformation> response = vaultTemplate.read("", DatasourceInformation.class);

        DatasourceInformation datasourceInformation = response.getData();

        return DataSourceBuilder.create()
                .password(datasourceInformation.getPassword())
                .username(datasourceInformation.getUsername())
                .build();
    }
}
