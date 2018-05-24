package com.vadim.site.services.command

import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

class AddCommand[M] (val repository:MongoRepository[M, ObjectId], val model: M) extends CrudCommand {
  override def execute: Unit = repository.save(model)
}
