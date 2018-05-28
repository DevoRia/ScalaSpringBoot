package com.vadim.site.services

import java.util

import com.google.common.collect.Lists
import com.vadim.site.dao.StudentRepository
import com.vadim.site.model.{Book, Model, Student}
import com.vadim.site.services.command.{AddCommand, EditCommand, FindAllCommand, RemoveCommand}
import org.bson.types.ObjectId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class StudentDataService(@Autowired repository: StudentRepository) extends Servicable {

  def getAllPosts (): util.ArrayList[Student] = Lists.newArrayList(new FindAllCommand[Student](repository).getAllPosts)

  def addPost(model: Student): Unit = new AddCommand[Student](repository, model).execute

  def editPost(model: Student): Unit = new EditCommand[Student](repository, model).execute

  override def removePost(id: ObjectId): Unit = new RemoveCommand[Student](repository, id).execute

  def findStudent (name: String): Student = repository.findStudentByName(name)

}
