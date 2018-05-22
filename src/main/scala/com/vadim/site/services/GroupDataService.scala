package com.vadim.site.services

import java.util
import java.util.Optional

import com.google.common.collect.Lists
import com.vadim.site.dao.GroupRepository
import com.vadim.site.model.{Book, Group, Model}
import org.bson.types.ObjectId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class GroupDataService (@Autowired repository: GroupRepository) extends Servicable {

  def getAllPosts (): util.ArrayList[Group] = Lists.newArrayList(repository.findAll())

  def addPost(model: Group): Unit = repository.save(model)

  def editPost(model: Group): Unit = this.addPost(model)

  override def removePost(id: ObjectId): Unit = repository.deleteById(id)

  def findById (id: ObjectId): Group = repository.findById(id).get()

}
