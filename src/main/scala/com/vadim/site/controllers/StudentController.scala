package com.vadim.site.controllers

import java.util

import com.vadim.site.model.{Book, Group, Student}
import com.vadim.site.services.{BookDataService, GroupDataService, Servicable, StudentDataService}
import org.bson.types.ObjectId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation._

@RestController
@RequestMapping(Array("/server"))
class StudentController(@Autowired val dataService: StudentDataService,
                       @Autowired val groupService: GroupDataService,
                       @Autowired val bookService: BookDataService){

  @CrossOrigin
  @GetMapping(Array("/show"))
  def getAllPosts: util.ArrayList[Student] = {
    dataService.getAllPosts()
  }

  @CrossOrigin
  @PostMapping(Array("/add"))
  def addStudent(
                @ModelAttribute("name") name: String,
                @ModelAttribute("group") group: String,
                @ModelAttribute("books") book: Array[String]
                ): String = {
    var books: util.List[Book] = new util.ArrayList[Book]()
    if (!book.isEmpty) books = bookService.findBooks(book)
    val student = new Student(new ObjectId(), name, groupService.findByName(group),books)
    dataService.addPost(student)
    "Success"
  }



}
