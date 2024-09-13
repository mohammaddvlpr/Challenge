package com.jabama.challenge.ui.search.model

import android.app.Application
import com.jabama.challenge.domain.usecase.search.model.SearchModel
import com.jabama.challenge.login.R

class UiMapper(private val appContext: Application) {

    fun mapToUi(searchModel: SearchModel): SearchUiModel {
        return SearchUiModel(
            fullName = searchModel.fullName,
            avatarUrl = searchModel.avatarUrl,
            url = searchModel.url,
            privacy = if (searchModel.isPrivate)
                appContext.getString(R.string.private_repo)
            else
                appContext.getString(R.string.public_repo)
        )
    }
}