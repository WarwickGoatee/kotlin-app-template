package uk.ac.warwick.example.system.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties("example.roles")
class RoleConfiguration {
  lateinit var adminWebgroup: String
  lateinit var sysadminWebgroup: String
  lateinit var masqueradersWebgroup: String
}
