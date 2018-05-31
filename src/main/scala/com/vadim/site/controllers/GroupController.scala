package com.vadim.site.controllers

import java.util

import com.vadim.site.model.Group
import com.vadim.site.services.GroupDataService
import org.bson.types.ObjectId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation._

@RestController
@RequestMapping(Array("/server/group"))
class GroupController (@Autowired dataService: GroupDataService) extends Router{

  @CrossOrigin
  @GetMapping(Array("/show"))
  def getAllPosts(): util.List[Group] = {
    dataService.getAllPosts()
  }

  @CrossOrigin
  @PostMapping(Array("/add"))
  def addGroup(@ModelAttribute("name") name: String): String = {
    val group = new Group(new ObjectId(), name)
    dataService.addPost(group)
    SUCCESS
  }

  @CrossOrigin
  @GetMapping(Array("/remove/{id}"))
  def removeStudentGroup(@PathVariable("id") id: String): String = {
    dataService.removePost(dataService.findByName(id).getId)
    SUCCESS
  }


}
