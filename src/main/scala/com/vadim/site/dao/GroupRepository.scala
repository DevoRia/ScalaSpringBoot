package com.vadim.site.dao

import com.vadim.site.model.Group
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.{MongoRepository, Query}
import org.springframework.stereotype.Repository

@Repository
trait GroupRepository extends MongoRepository[Group, ObjectId]{

  @Query("{ 'name' : ?0 }")
  def findByName(name: String): Group

}
