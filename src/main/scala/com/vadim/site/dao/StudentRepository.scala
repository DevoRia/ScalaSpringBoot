package com.vadim.site.dao

import com.vadim.site.model.{Book, Student}
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.{MongoRepository, Query}
import org.springframework.stereotype.Repository

@Repository
trait StudentRepository extends MongoRepository[Student, ObjectId]{

  def findByName (): List[Student]

  @Query("{'student.books': ?0}")
  def fingByBook (): List[Book]

}
