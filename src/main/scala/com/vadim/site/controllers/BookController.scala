package com.vadim.site.controllers

import com.vadim.site.model.{Book, Student}
import org.springframework.web.bind.annotation._
import java.util

import com.vadim.site.services.BookDataService
import org.bson.types.ObjectId
import org.springframework.beans.factory.annotation.Autowired

@RestController
@RequestMapping(Array("/server/book"))
class BookController (@Autowired bookDataService: BookDataService)  extends Router {

  @CrossOrigin
  @GetMapping(Array("/show"))
  def getAllBooks (): util.List[Book] = bookDataService.getAllPosts()

  @CrossOrigin
  @PostMapping(Array("/add"))
  def addBook(@ModelAttribute("title") title: String): String = {
    val book = new Book(new ObjectId(), title, 0)
    bookDataService.addPost(book)
    SUCCESS
  }

}
