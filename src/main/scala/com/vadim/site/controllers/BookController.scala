package com.vadim.site.controllers

import com.vadim.site.model.Book
import org.springframework.web.bind.annotation.{CrossOrigin, GetMapping, RequestMapping, RestController}
import java.util

import com.vadim.site.services.BookDataService
import org.springframework.beans.factory.annotation.Autowired

@RestController
@RequestMapping(Array("/server/book"))
class BookController (@Autowired bookDataService: BookDataService) {

  @CrossOrigin
  @GetMapping(Array("/show"))
  def getAllBooks (): util.List[Book] = bookDataService.getAllPosts()

}
