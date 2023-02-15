package com.example.flixster

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MoviesRecyclerViewAdapter(private val mMovies: List<Movie>
): RecyclerView.Adapter<MoviesRecyclerViewAdapter.ViewHolder>() {


  inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val movieImage: ImageView = itemView.findViewById(R.id.imageView)
    val movieTitle: TextView = itemView.findViewById(R.id.movie_title_textView)
    val movieDescription: TextView = itemView.findViewById(R.id.movie_description_textView)
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val view = LayoutInflater.from(parent.context)
      .inflate(R.layout.fragment_movie, parent, false)
    return ViewHolder(view)
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    val movie = mMovies[position]

//        holder.mItem = book
//        holder.mBookTitle.text = book.title
//        holder.mBookAuthor.text = book.author
//        holder.mBookDescription.text = book.overview
//        holder.mBookRanking.text = book.rank.toString()

    holder.movieTitle.text = movie.title
    holder.movieDescription.text = movie.overview

    Glide.with(holder.itemView)
      .load("https://image.tmdb.org/t/p/w500/${movie.poster_path}")
      .placeholder(R.drawable.ic_launcher_background)
      .error(com.facebook.stetho.R.drawable.abc_ab_share_pack_mtrl_alpha)
      .centerInside()
      .into(holder.movieImage)

  }

  override fun getItemCount(): Int {
    return mMovies.size
  }
}
