package com.vadim.site.services

import java.util

import com.google.common.collect.Lists
import com.vadim.site.dao.{BookRepository, GroupRepository}
import com.vadim.site.model.{Book, Model, Student}
import org.bson.types.ObjectId
import org.springframework.beans.factory.annotation.{Autowired, Qualifier}
import org.springframework.stereotype.Service

@Service
class BookDataService(@Autowired val repository: BookRepository) extends Servicable {

  def getAllPosts (): util.ArrayList[Book] = Lists.newArrayList(repository.findAll())

  def addPost(model: Book): Unit = repository.save(model)

  def editPost(model: Book): Unit = this.addPost(model)

  override def removePost(id: ObjectId): Unit = repository.deleteById(id)
}
