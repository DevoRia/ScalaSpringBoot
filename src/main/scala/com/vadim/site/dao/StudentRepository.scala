package com.vadim.site.dao

import com.vadim.site.model.{Student}
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.{MongoRepository}
import org.springframework.stereotype.Repository

@Repository
trait StudentRepository extends MongoRepository[Student, ObjectId]{
}
