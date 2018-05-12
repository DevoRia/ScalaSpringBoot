package com.vadim.site.services

import java.util

import com.google.common.collect.Lists
import com.vadim.site.dao.MainRepository
import com.vadim.site.model.Post
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DataService (@Autowired repository: MainRepository){

  def getAllPosts (): util.ArrayList[Post] = {
    Lists.newArrayList(repository.findAll())
  }

}
