package com.cristianvillamil.platziwallet.ui.home.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cristianvillamil.platziwallet.R
import com.cristianvillamil.platziwallet.ui.home.FavoriteTransfer
import com.cristianvillamil.platziwallet.ui.home.HomeContract
import com.cristianvillamil.platziwallet.ui.home.data.HomeInteractor
import com.cristianvillamil.platziwallet.ui.home.presenter.HomePresenter
import com.cristianvillamil.platziwallet.ui.observable.BalanceObserver
import com.cristianvillamil.platziwallet.ui.observable.Observer
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(), HomeContract.View {

    private val favoriteTransferAdapter = FavoriteTransferAdapter()

    private var homePresenter : HomeContract.Presenter? = null

    private val balanceObserver = BalanceObserver()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.fragment_home,
            container,
            false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        circularProgress.setProgressWithAnimation(
            70f,
            1000,
            AccelerateDecelerateInterpolator(),
            500
        )
        Picasso
            .get()
            .load("https://media.licdn.com/dms/image/C4E03AQFcCuDIJl0mKg/profile-displayphoto-shrink_200_200/0?e=1583366400&v=beta&t=ymt3xgMe5bKS-2knNDL9mQYFksP9ZHne5ugIqEyRjZs")
            .into(profilePhotoImageView)
        homePresenter = HomePresenter(
            this,
            HomeInteractor()
        )
        homePresenter?.retrieveFavoriteTransfers()
        balanceObserver.addObserver(
            object : Observer {
                override fun notifyChange(newValue: Double) {
                    amountValueTextView.text = "$ $newValue"
                }
            }
        )
    }

    override fun onDestroyView() {
        Log.i("onDestroyView","se destruyo")
        homePresenter = null
        super.onDestroyView()
    }

    private fun initRecyclerView() {
        favoriteTransfersRecyclerView.layoutManager = LinearLayoutManager(
            context,
            RecyclerView.HORIZONTAL,
            false
        )
        favoriteTransfersRecyclerView.adapter = favoriteTransferAdapter
    }

    //Validar el estado de nulidad del view es mas que suficiente para evitar crashes
    override fun showLoader() {
        homeProgressBar?.visibility = View.VISIBLE
    }

    override fun hideLoader() {
        homeProgressBar?.visibility = View.GONE
    }

    override fun showFavoriteTransfers(favoriteTransfers: List<FavoriteTransfer>) {
        favoriteTransferAdapter.setData(favoriteTransfers)
    }
}