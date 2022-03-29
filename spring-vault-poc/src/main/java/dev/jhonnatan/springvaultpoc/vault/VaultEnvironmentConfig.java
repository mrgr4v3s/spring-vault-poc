package dev.jhonnatan.springvaultpoc.vault;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.vault.config.EnvironmentVaultConfiguration;

@Configuration
@PropertySource(value = { "vault-config.properties" })
@Import({EnvironmentVaultConfiguration.class})
public class VaultEnvironmentConfig {
}
