package uk.ac.warwick.example.controllers

import org.junit.Assert.assertEquals
import org.junit.Test

class HomeControllerTest {
  private val controller = HomeController()

  @Test
  fun home() = assertEquals("home", controller.home().viewName)
}
