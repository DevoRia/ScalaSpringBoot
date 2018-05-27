package com.vadim.site.services

import java.util
import java.util.Optional

import com.google.common.collect.Lists
import com.vadim.site.dao.GroupRepository
import com.vadim.site.model.{Book, Group, Model}
import com.vadim.site.services.command.{AddCommand, EditCommand, FindAllCommand, RemoveCommand}
import org.bson.types.ObjectId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Example
import org.springframework.stereotype.Service

@Service
class GroupDataService (@Autowired repository: GroupRepository) extends Servicable {

  def getAllPosts (): util.ArrayList[Group] = Lists.newArrayList(new FindAllCommand[Group](repository).getAllPosts)

  def addPost(model: Group): Unit = new AddCommand[Group](repository, model).execute

  def editPost(model: Group): Unit = new EditCommand[Group](repository, model).execute

  override def removePost(id: ObjectId): Unit = new RemoveCommand[Group](repository, id).execute

  def findById (id: ObjectId): Group = repository.findById(id).get()

  def findByName (name: String): Group = repository.findByName(name)

}
