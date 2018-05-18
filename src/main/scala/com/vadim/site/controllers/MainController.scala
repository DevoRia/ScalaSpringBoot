package com.vadim.site.controllers

import java.util

import com.vadim.site.model.{Book, Student}
import com.vadim.site.services.DataService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.{GetMapping, RequestMapping, RestController}

@RestController
@RequestMapping(Array("/server"))
class MainController (@Autowired val dataService: DataService){

  @GetMapping(Array("/show"))
  def getAllPosts: util.ArrayList[Student] = {
    dataService.getAllPosts()
  }

  @GetMapping(Array("/books"))
  def getBooks: util.List[Book] = {
    dataService.getBooks()
  }


}
