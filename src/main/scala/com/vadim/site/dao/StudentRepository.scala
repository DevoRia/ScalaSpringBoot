package com.vadim.site.dao

import com.vadim.site.model.Student
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.{MongoRepository, Query}
import org.springframework.stereotype.Repository

@Repository
trait StudentRepository extends MongoRepository[Student, ObjectId]{

  @Query("{'name': ?0 }")
  def findStudentByName(name: String): Student

}
