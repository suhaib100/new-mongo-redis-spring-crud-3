package com.redis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@RedisHash(value = "order")
@Document(collection = "order_details")
public class Order implements Serializable {

//    private static final long serialVersionUID = 214101981905645865L;


    @Id
    private String id;
    private String oderDetails;

}
