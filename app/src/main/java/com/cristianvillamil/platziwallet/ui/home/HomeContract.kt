package com.cristianvillamil.platziwallet.ui.home

interface HomeContract {

    interface View{
        fun showLoader()
        fun hideLoader()
        fun showFavoriteTransfers(favoriteTransfers:List<FavoriteTransfer>)
    }

    interface Presenter{
        fun retrieveFavoriteTransfers()
    }

    interface OnResponseCallback{
        fun onResponse(favoriteListTransfer:List<FavoriteTransfer>)
    }

}