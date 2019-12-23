package uk.ac.warwick.example.mvc

import org.hamcrest.CoreMatchers.containsString
import org.junit.Test
import org.springframework.security.test.context.support.WithAnonymousUser
import org.springframework.security.test.context.support.WithMockUser
import org.springframework.test.web.servlet.get
import uk.ac.warwick.example.system.security.Role

class HomeMvcTest : MvcTest() {
  @Test
  @WithMockUser(roles = [Role.user])
  fun homeSignedIn() {
    mvc.get("/").andExpect {
      status { isOk }
      content { string(containsString("Kotlin")) }
    }
  }

  @Test
  @WithAnonymousUser
  fun homeSignedOut() {
    mvc.get("/").andExpect {
      status { isForbidden }
    }
  }
}
