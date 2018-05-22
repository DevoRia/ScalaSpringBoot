package com.vadim.site.services

import java.util

import com.google.common.collect.Lists
import com.vadim.site.dao.StudentRepository
import com.vadim.site.model.{Book, Model, Student}
import org.bson.types.ObjectId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class StudentDataService(@Autowired repository: StudentRepository) extends Servicable {

  def getAllPosts (): util.ArrayList[Student] = Lists.newArrayList(repository.findAll())

  def addPost(model: Student): Unit = repository.save(model)

  def editPost(model: Student): Unit = this.addPost(model)

  override def removePost(id: ObjectId): Unit = repository.deleteById(id)

}
