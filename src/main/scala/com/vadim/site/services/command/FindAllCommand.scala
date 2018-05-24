package com.vadim.site.services.command

import java.util

import com.vadim.site.model.Student
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

class FindAllCommand[M] (val repository:MongoRepository[M, ObjectId]) extends CrudCommand {
  override def execute: Unit = {}

  def getAllPosts: util.List[M] = repository.findAll()
}
