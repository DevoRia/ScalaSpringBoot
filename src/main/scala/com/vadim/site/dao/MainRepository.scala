package com.vadim.site.dao

import com.vadim.site.model.Post
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
trait MainRepository extends MongoRepository[Post, String]{

}
