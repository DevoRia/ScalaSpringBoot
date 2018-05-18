package com.vadim.site.services

import java.util

import com.google.common.collect.Lists
import com.vadim.site.dao.{BookRepository, StudentRepository}
import com.vadim.site.model.{Book, Student}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DataService (@Autowired repositoryStudent: StudentRepository,
                   @Autowired repositoryBook :BookRepository){
  def getBooks(): util.List[Book] = {
    Lists.newArrayList(repositoryBook.findAll())
  }


  def getAllPosts (): util.ArrayList[Student] = {
    Lists.newArrayList(repositoryStudent.findAll())
  }


}
