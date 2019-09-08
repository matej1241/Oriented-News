package com.matej.orientednews.domain.news

import com.matej.orientednews.common.IndexErrorLambda
import com.matej.orientednews.common.SuccessLambda
import com.matej.orientednews.model.rss.RssFeed

interface IndexRssUseCase {
    fun execute(successLambda: SuccessLambda<RssFeed>, onFailure: IndexErrorLambda)
}