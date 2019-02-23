package com.efunhub.furniture.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.efunhub.furniture.Adapter.BookShelvesListAdapter;
import com.efunhub.furniture.Model.BookShelvesListModel;
import com.efunhub.furniture.R;

import java.util.ArrayList;


public class BookshelvesFragment extends Fragment
{
    View view;

    //Top Selling Products
    RecyclerView rv_BookShelfList;
    BookShelvesListAdapter mBookShelvesListAdapter;
    ArrayList<BookShelvesListModel> bookShelvesListModelArrayList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_bookshelves, container, false);

        init();

        bookShelvesListModelArrayList = new ArrayList<>();

        //Sofa Name List
        ArrayList<String> BookShelfName= new ArrayList<>();
        BookShelfName.add("Malabar BookShelves ");
        BookShelfName.add("Alberto BookShelves");
        BookShelfName.add("BeoBerg BookShelves");
        BookShelfName.add("Iwaki BookShelves");
        BookShelfName.add("Malabar BookShelves ");
        BookShelfName.add("Alberto BookShelves");
        BookShelfName.add("BeoBerg BookShelves");
        BookShelfName.add("Iwaki BookShelves");

        //Sofa Image List
        ArrayList<String> BookShelfImageList = new ArrayList<>();
        BookShelfImageList.add("https://ul-a.akamaihd.net/opt/ul-a.akamaihd.net/images/products/109039/product/Malabar_Display_Unit_00_LP.jpg?1474888939");
        BookShelfImageList.add("https://ul-a.akamaihd.net/opt/ul-a.akamaihd.net/images/products/153013/product/Alberto_Bookshelf_teak_LP.jpg?1502342558");
        BookShelfImageList.add("https://ul-a.akamaihd.net/opt/ul-a.akamaihd.net/images/products/60319/product/BOEBERG_BOOKSHELF_4X4_%28DARK_WALNUT%29_00_LP.jpg?1446030672");
        BookShelfImageList.add("https://ul-a.akamaihd.net/opt/ul-a.akamaihd.net/images/products/40907/product/Ikawa_00_LP.jpg?1436521458");
        BookShelfImageList.add("https://ul-a.akamaihd.net/opt/ul-a.akamaihd.net/images/products/109039/product/Malabar_Display_Unit_00_LP.jpg?1474888939");
        BookShelfImageList.add("https://ul-a.akamaihd.net/opt/ul-a.akamaihd.net/images/products/153013/product/Alberto_Bookshelf_teak_LP.jpg?1502342558");
        BookShelfImageList.add("https://ul-a.akamaihd.net/opt/ul-a.akamaihd.net/images/products/60319/product/BOEBERG_BOOKSHELF_4X4_%28DARK_WALNUT%29_00_LP.jpg?1446030672");
        BookShelfImageList.add("https://ul-a.akamaihd.net/opt/ul-a.akamaihd.net/images/products/40907/product/Ikawa_00_LP.jpg?1436521458");

        //Sofa Name List
        ArrayList<String> BookShelfFinish= new ArrayList<>();
        BookShelfFinish.add("Teak Finish");
        BookShelfFinish.add("Walnut Finish");
        BookShelfFinish.add("Two-Tone Finish");
        BookShelfFinish.add("Mahogany Finish");
        BookShelfFinish.add("Two-Tone Finish");
        BookShelfFinish.add("Two-Tone Finish");
        BookShelfFinish.add("Mahogany Finish");
        BookShelfFinish.add("Two-Tone Finish");

        //Sofa Price List
        ArrayList<String> BookShelfPrice= new ArrayList<>();
        BookShelfPrice.add("Rs. 15,999");
        BookShelfPrice.add("Rs. 11,299");
        BookShelfPrice.add("Rs. 10,999");
        BookShelfPrice.add("Rs. 30,999");
        BookShelfPrice.add("Rs. 15,999");
        BookShelfPrice.add("Rs. 11,299");
        BookShelfPrice.add("Rs. 10,999");
        BookShelfPrice.add("Rs. 30,999");

        //Sofa List Items
        for (int i = 0; i <BookShelfImageList.size(); i++)
        {
            BookShelvesListModel bookShelvesListModel = new BookShelvesListModel();
            bookShelvesListModel.setBookShelfName(BookShelfName.get(i));
            bookShelvesListModel.setBookShelfFinish(BookShelfFinish.get(i));
            bookShelvesListModel.setBookShelfPrice(BookShelfPrice.get(i));
            bookShelvesListModel.setBookShelfImage(BookShelfImageList.get(i));
            bookShelvesListModelArrayList.add(bookShelvesListModel);
        }

        //Sofa Set Adapter
        mBookShelvesListAdapter = new BookShelvesListAdapter(getContext(), bookShelvesListModelArrayList);
        rv_BookShelfList.setHasFixedSize(true);
        rv_BookShelfList.setNestedScrollingEnabled(false);
        GridLayoutManager topSelling = new GridLayoutManager(getContext(), 2);
        rv_BookShelfList.setLayoutManager(topSelling);
        rv_BookShelfList.setItemAnimator(new DefaultItemAnimator());
        rv_BookShelfList.setAdapter(mBookShelvesListAdapter);

        return view;
    }

    private void init()
    {
        rv_BookShelfList = view.findViewById(R.id.rv_BookShelf);
    }
}
