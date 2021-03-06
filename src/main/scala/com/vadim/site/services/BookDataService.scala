package com.vadim.site.services

import java.util

import com.google.common.collect.Lists
import com.vadim.site.dao.{BookRepository, GroupRepository}
import com.vadim.site.model.{Book, Model, Student}
import com.vadim.site.services.command.{AddCommand, CrudCommand, EditCommand, RemoveCommand}
import org.bson.types.ObjectId
import org.springframework.beans.factory.annotation.{Autowired, Qualifier}
import org.springframework.stereotype.Service

@Service
class BookDataService(@Autowired val repository: BookRepository) extends Servicable[Book] {

  override def getAllPosts (): util.ArrayList[Book] = Lists.newArrayList(repository.findAll())

  override def addPost(model: Book): Unit = new AddCommand[Book](repository, model).execute

  override def editPost(model: Book): Unit = new EditCommand[Book](repository, model).execute

  override def removePost(id: ObjectId): Unit = new RemoveCommand[Book](repository, id).execute

  def findBooks(list: Array[String]): util.List[Book]= {
    val books: util.List[Book] = new util.ArrayList[Book]()
    list.foreach(title => books.add(repository.findBookByTitle(title)))
    books
  }
}
