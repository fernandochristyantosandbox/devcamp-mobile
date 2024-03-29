package com.devcamp.devcamp_mobile.service

import com.devcamp.devcamp_mobile.common.GarageSaleProduct
import com.devcamp.devcamp_mobile.common.GarageSaleProductListItem
import com.devcamp.devcamp_mobile.common.dto.AddItemRequestDTO
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface GarageSaleService{
    @GET("/products/garagesale")
    fun getAllGarageSaleProducts(): Single<List<GarageSaleProductListItem>>

    @POST("/products/garagesale")
    fun addNewItems(@Body itemDTO: AddItemRequestDTO): Single<GarageSaleProduct>
}