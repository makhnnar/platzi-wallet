package com.cristianvillamil.platziwallet.ui.home.presenter

import com.cristianvillamil.platziwallet.ui.home.FavoriteTransfer
import com.cristianvillamil.platziwallet.ui.home.HomeContract
import com.cristianvillamil.platziwallet.ui.home.data.HomeInteractor

class HomePresenter(
    private val view: HomeContract.View,
    private val homeInteractor: HomeInteractor
): HomeContract.Presenter {

    override fun retrieveFavoriteTransfers(){
        view.showLoader()
        homeInteractor.retrieveFavoriteTransferFromCache(object:HomeContract.OnResponseCallback{
            override fun onResponse(favoriteListTransfer: List<FavoriteTransfer>) {
                view.hideLoader()
                view.showFavoriteTransfers(favoriteListTransfer)
            }
        })
    }

}