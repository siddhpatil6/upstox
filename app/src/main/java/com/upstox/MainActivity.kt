package com.upstox

import android.annotation.SuppressLint
import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.upstox.adapter.CryptoAdapter
import com.upstox.data.CryptoItem
import com.upstox.data.FilterTypeItem
import com.upstox.databinding.ActivityMainBinding
import com.upstox.di.CryptoListViewModelFactory
import com.upstox.directory.FilterBottomSheet
import com.upstox.interfaces.BottomSheetListener
import com.upstox.utils.Constants
import com.upstox.viewmodel.CryptoViewModel


class MainActivity : AppCompatActivity(), BottomSheetListener {

    private val forthCodeListViewModel: CryptoViewModel by viewModels { CryptoListViewModelFactory() }
    private val searchList = ArrayList<CryptoItem>()
    private val filterTypeList = HashSet<String>()
    private val cryptoList = ArrayList<CryptoItem>()
    private var adapter :CryptoAdapter? = null
    private val filteredSet = HashSet<CryptoItem>()
    private val searchFilteredList = ArrayList<CryptoItem>()
    private var filterBottomSheet: FilterBottomSheet ? =null
    private var searchView: SearchView? = null
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setSupportActionBar(binding.toolbar)
        getCallCoinAPI()
        binding.txtFilter.setOnClickListener {
            searchView?.isIconified = true
            filterBottomSheet?.show(supportFragmentManager, filterBottomSheet?.tag)
        }
    }

    private fun getCallCoinAPI(){
        forthCodeListViewModel.getListOfPhotos()
        forthCodeListViewModel.photosItem.observe(this, Observer { response ->
            cryptoList.addAll(response)
            searchList.addAll(response)
            searchFilteredList.addAll(response)
            setCoinListAdapter()
            setCoinFilterAdapter()
        })
    }

    private fun setCoinListAdapter() {
        adapter = CryptoAdapter()
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this@MainActivity)
        binding.rvPhotos.layoutManager = layoutManager
        binding.rvPhotos.adapter = adapter
        binding.rvPhotos.addItemDecoration(
            DividerItemDecoration(
                this.applicationContext,
                LinearLayout.VERTICAL
            )
        )
        adapter?.submitList(searchList)
    }

    private fun setCoinFilterAdapter(){
        searchList.forEach { filterOption ->
            filterTypeList.add(filterOption.type)
        }
        filterBottomSheet = FilterBottomSheet.newInstance()
        filterBottomSheet?.setBottomSheetListener(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)

        val searchItem: MenuItem? = menu?.findItem(R.id.action_search)
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        searchView = searchItem?.actionView as SearchView


        searchView?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {

                return false
            }
            @SuppressLint("NotifyDataSetChanged")
            override fun onQueryTextChange(newText: String?): Boolean {
                  if (newText?.isNotEmpty() == true){
                      searchList.clear()
                      for (item in searchFilteredList) {
                          if (item.name.lowercase().contains(newText?.lowercase()?:"")){
                              searchList.add(item);
                          }
                      }
                  }else{
                      searchList.clear()
                      searchList.addAll(searchFilteredList)
                  }
                adapter?.notifyDataSetChanged()
                return false
            }
        })

        searchView?.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        return super.onCreateOptionsMenu(menu)
    }

    override fun onActionSelected(fiterOptionSet : List<FilterTypeItem>?) {
        filteredSet.clear()
        fiterOptionSet?.forEach { action ->
            if (action.isSelected){
            when(action.type){
                Constants.ACTIVE_COINS -> {
                    cryptoList.forEach { item ->
                        if (item.is_active && item.type == Constants.COIN) filteredSet.add(item)
                    }
                }
                Constants.INACTIVE_COINS ->{
                    cryptoList.forEach { item ->
                        if (!item.is_active && item.type == Constants.COIN) filteredSet.add(item)
                    }
                }
                Constants.ONLY_TOKENS -> {
                    cryptoList.forEach { item ->
                        if (item.type == Constants.TOKEN) filteredSet.add(item)
                    }
                }
                Constants.ONLY_COINS -> {
                    cryptoList.forEach { item ->
                        if (item.type == Constants.COIN) filteredSet.add(item)
                    }
                }
                Constants.NEW_COINS -> {
                    cryptoList.forEach { item ->
                        if (item.is_new && item.type == Constants.COIN) filteredSet.add(item)
                    }
                }
            }
            }
        }

        searchFilteredList.clear()
        searchFilteredList.addAll(filteredSet.toList())
        adapter?.submitList(searchFilteredList)
        adapter?.notifyDataSetChanged()
    }

}


