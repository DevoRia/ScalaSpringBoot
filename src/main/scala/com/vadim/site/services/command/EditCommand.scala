package com.vadim.site.services.command

import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

class EditCommand[M] (val repository:MongoRepository[M, ObjectId], val model: M) extends CrudCommand{
  override def execute: Unit = new AddCommand[M](repository, model).execute
}
