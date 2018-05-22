package com.vadim.site.controllers

import java.util

import com.vadim.site.model.Group
import com.vadim.site.services.GroupDataService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.{CrossOrigin, GetMapping, RequestMapping, RestController}

@RestController
@RequestMapping(Array("/server/group"))
class GroupController (@Autowired dataService: GroupDataService) {

  @CrossOrigin
  @GetMapping(Array("/show"))
  def getAllPosts(): util.List[Group] = {
    dataService.getAllPosts()
  }

}
