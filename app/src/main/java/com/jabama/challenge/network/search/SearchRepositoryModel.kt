package com.jabama.challenge.network.search

import com.google.gson.annotations.SerializedName

data class SearchRepositoryModel(@SerializedName("items") val items: List<SearchRepositorySingleModel>)
