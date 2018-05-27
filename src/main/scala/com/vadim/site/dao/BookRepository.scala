package com.vadim.site.dao

import com.vadim.site.model.Book
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.{MongoRepository, Query}
import org.springframework.stereotype.Repository

import java.util

@Repository
trait BookRepository extends MongoRepository[Book, ObjectId]{

  @Query("{'title': ?0 }")
  def findBookByTitle(title: String): Book

}
