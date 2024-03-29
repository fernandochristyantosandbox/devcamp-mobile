package com.devcamp.devcamp_mobile.module.garage_sale

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.devcamp.devcamp_mobile.R
import com.devcamp.devcamp_mobile.common.GarageSaleProduct
import com.devcamp.devcamp_mobile.common.GarageSaleProductListItem
import com.devcamp.devcamp_mobile.module.product_detail.ProductDetailActivity
import de.hdodenhof.circleimageview.CircleImageView

class GarageSaleProductAdapter(val dataList: List<GarageSaleProductListItem>):RecyclerView.Adapter<GarageSaleProductAdapter.GarageSaleProductViewHolder>() {

    class GarageSaleProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        lateinit var product: GarageSaleProductListItem

        override fun onClick(v: View?) {
            val intent = ProductDetailActivity.newIntent(itemView.context, product.id)
            itemView.context.startActivity(intent)
        }

        fun bind(productListItem: GarageSaleProductListItem){
            product = productListItem
        }

        val imItemImage: ImageView
        val tvShopName: TextView
        val tvItemName: TextView
        val tvPrice: TextView
        val charityIcon: CircleImageView

        init {
            imItemImage = itemView.findViewById(R.id.imItemImage)
            tvShopName = itemView.findViewById(R.id.tvShopName)
            tvItemName = itemView.findViewById(R.id.tvItemName)
            tvPrice = itemView.findViewById(R.id.tvPrice)
            charityIcon = itemView.findViewById(R.id.charity_icon)
            itemView.setOnClickListener(this)
        }
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: GarageSaleProductViewHolder, position: Int) {
        holder.tvItemName.text = dataList[position].name
        holder.tvPrice.text = dataList[position].price.toString()
        holder.tvShopName.text = dataList[position].shopName
        Glide.with(holder.itemView).load(dataList[position].imageUrl).into(holder.imItemImage)

        if (dataList[position].charity) {
            holder.charityIcon.visibility = View.VISIBLE
        } else {
            holder.charityIcon.visibility = View.GONE
        }
        holder.bind(dataList[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GarageSaleProductViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.list_item_garage_sale, parent, false)
        return GarageSaleProductViewHolder(view)

    }
}