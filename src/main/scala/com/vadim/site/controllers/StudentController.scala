package com.vadim.site.controllers

import java.util
import java.util.Optional

import com.vadim.site.model.{Book, Group, Student}
import com.vadim.site.services.{BookDataService, GroupDataService, Servicable, StudentDataService}
import org.bson.types.ObjectId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation._

@RestController
@RequestMapping(Array("/server"))
class StudentController(@Autowired val dataService: StudentDataService,
                       @Autowired val groupService: GroupDataService,
                       @Autowired val bookService: BookDataService) extends Router {

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
    val student = new Student(new ObjectId(), name, groupService.findByName(group),checkBooks(book))
    dataService.addPost(student)
    SUCCESS
  }

  @CrossOrigin
  @PostMapping(Array("/edit"))
  def editStudent (@ModelAttribute("name") name: String,
                   @ModelAttribute("group") group: String,
                   @ModelAttribute("books") book: Array[String]
                  ): String = {
    val student = new Student(dataService.findStudent(name).getId, name, groupService.findByName(group),checkBooks(book))
    dataService.editPost(student)
    SUCCESS
  }

  @CrossOrigin
  @GetMapping(Array("/remove/{id}"))
  def removeStudent(@PathVariable("id") id: String): String = {
    dataService.removePost(dataService.findStudent(id).getId)
    SUCCESS
  }

  def checkBooks (book :Array[String]): util.List[Book] ={
    if (!book.isEmpty) bookService.findBooks(book)
    else new util.ArrayList[Book]()
  }



}
