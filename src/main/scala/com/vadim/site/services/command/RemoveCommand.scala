package com.vadim.site.services.command

import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

class RemoveCommand[M] (val repository:MongoRepository[M, ObjectId], objectId: ObjectId) extends CrudCommand {
  override def execute: Unit = repository.deleteById(objectId)

}
